package ru.otus.homework.config;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.homework.domain.Author;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final MongoTemplate mongoTemplate;


    @StepScope
    @Bean
    public MongoItemReader<Author> authorMongoItemReader(MongoTemplate mongoTemplate){
        return new MongoItemReaderBuilder<Author>()
                .name("authorItemReaded")
                .template(mongoTemplate)
                .targetType(Author.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Author,Author> authorItemProcessor(){
        return author ->author;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<Author> authorJdbcBatchItemWriter() {
        JdbcBatchItemWriter<Author> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO author (id,name) VALUES (:id,:name)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step authorStep(){
        return stepBuilderFactory.get("authorStep")
                .<Author,Author>chunk(10)
                .reader(authorMongoItemReader(mongoTemplate))
                .processor(authorItemProcessor())
                .writer(authorJdbcBatchItemWriter())
                .build();
    }

    @Bean
    public Job migrateMongoToMySql(){
        return jobBuilderFactory.get("migrateMongoToMySql")
                .start(authorStep())
                .build();
    }

}
