package ru.otus.homework.config;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.homework.changelogs.DatabaseChangeLog;

@Configuration
public class MongoBeeConfig {

    private final MongoClient mongo;
    private final MongoTemplate mongoTemplate;
    private final MongoProps mongoProps;

    public MongoBeeConfig(MongoClient mongo, MongoTemplate mongoTemplate, MongoProps mongoProps) {
        this.mongo = mongo;
        this.mongoTemplate = mongoTemplate;
        this.mongoProps = mongoProps;
    }

    @Bean
    public Mongobee mongobee(Environment environment) {
        Mongobee runner = new Mongobee(mongo);
        runner.setDbName(mongoProps.getDatabase());
        runner.setChangeLogsScanPackage(DatabaseChangeLog.class.getPackage().getName());
        runner.setSpringEnvironment(environment);
        runner.setMongoTemplate(mongoTemplate);
        return runner;
    }
}

