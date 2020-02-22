package ru.otus.homework.config;

import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongockConfig {
    private static final String CHANGELOGS = "ru.otus.homework.changelogs";
    private final MongoProps mongoProps;

    public MongockConfig(MongoProps mongoProps) {
        this.mongoProps = mongoProps;
    }

    @Bean
    public SpringBootMongock mongock(ApplicationContext springContext, MongoClient mongoClient) {
        return new SpringBootMongockBuilder(mongoClient, mongoProps.getDatabase(), CHANGELOGS)
                .setApplicationContext(springContext)
                .setLockQuickConfig()
                .build();
    }
}

