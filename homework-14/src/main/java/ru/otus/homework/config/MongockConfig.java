package ru.otus.homework.config;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.homework.changelogs.DatabaseChangeLog;

@Configuration
public class MongockConfig {

    private final MongoProps mongoProps;

    public MongockConfig(MongoProps mongoProps) {
        this.mongoProps = mongoProps;
    }

    @Bean
    public Mongock mongock(MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, mongoProps.getDatabase(),
                DatabaseChangeLog.class.getPackageName())
                .build();
    }
}

