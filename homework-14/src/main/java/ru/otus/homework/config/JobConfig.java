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
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.dto.CommentDTO;
import ru.otus.homework.processor.CommentDTOProcessor;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final MongoTemplate mongoTemplate;
    private final CommentDTOProcessor commentDTOProcessor;


    @StepScope
    @Bean
    public MongoItemReader<Author> authorMongoItemReader(MongoTemplate mongoTemplate) {
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
    public ItemProcessor<Author, Author> authorItemProcessor() {
        return author -> author;
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

    @StepScope
    @Bean
    public MongoItemReader<Genre> genreMongoItemReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<Genre>()
                .name("genreMongoItemReader")
                .template(mongoTemplate)
                .targetType(Genre.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Genre, Genre> genreItemProcessor() {
        return genre -> genre;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<Genre> genreJdbcBatchItemWriter() {
        JdbcBatchItemWriter<Genre> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO genre (id,name) VALUES (:id,:name)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @StepScope
    @Bean
    public MongoItemReader<Book> bookMongoItemReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<Book>()
                .name("bookMongoItemReader")
                .template(mongoTemplate)
                .targetType(Book.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Book, Book> bookItemProcessor() {
        return book -> book;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<Book> bookJdbcBatchItemWriter() {
        JdbcBatchItemWriter<Book> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO book (id,title,genre_id,author_id) VALUES (:id,:title,:genre.id,:author.id)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @StepScope
    @Bean
    public MongoItemReader<Comment> commentMongoItemReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<Comment>()
                .name("commentMongoItemReader")
                .template(mongoTemplate)
                .targetType(Comment.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Comment, CommentDTO> commentItemProcessor() {
        return commentDTOProcessor;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<CommentDTO> commentJdbcBatchItemWriter() {
        JdbcBatchItemWriter<CommentDTO> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO comment (id,text,book_id) VALUES (:id,:text,:bookId)");
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean
    public Step authorStep() {
        return stepBuilderFactory.get("authorStep")
                .<Author, Author>chunk(10)
                .reader(authorMongoItemReader(mongoTemplate))
                .processor(authorItemProcessor())
                .writer(authorJdbcBatchItemWriter())
                .build();
    }

    @Bean
    public Step genreStep() {
        return stepBuilderFactory.get("genreStep")
                .<Genre, Genre>chunk(10)
                .reader(genreMongoItemReader(mongoTemplate))
                .processor(genreItemProcessor())
                .writer(genreJdbcBatchItemWriter())
                .build();
    }

    @Bean
    public Step bookStep() {
        return stepBuilderFactory.get("bookStep")
                .<Book, Book>chunk(10)
                .reader(bookMongoItemReader(mongoTemplate))
                .processor(bookItemProcessor())
                .writer(bookJdbcBatchItemWriter())
                .build();
    }

    @Bean
    public Step commentStep() {
        return stepBuilderFactory.get("commentStep")
                .<Comment, CommentDTO>chunk(10)
                .reader(commentMongoItemReader(mongoTemplate))
                .processor(commentItemProcessor())
                .writer(commentJdbcBatchItemWriter())
                .build();
    }


    @Bean
    public Job migrateMongoToMySql() {
        return jobBuilderFactory.get("migrateMongoToMySql")
                .start(authorStep())
                .next(genreStep())
                .next(bookStep())
                .next(commentStep())
                .build();
    }
}
