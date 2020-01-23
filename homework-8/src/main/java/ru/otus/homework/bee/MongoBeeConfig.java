package ru.otus.homework.bee;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.otus.homework.bee.changelog.DatabaseChangeLog;

@Configuration
public class MongoBeeConfig {

    private final MongoClient mongo;

    public MongoBeeConfig(MongoClient mongo) {
        this.mongo = mongo;
    }

    @Bean
    public Mongobee mongobee(Environment environment) {
        Mongobee runner = new Mongobee(mongo);
        runner.setDbName("company");
        runner.setChangeLogsScanPackage(DatabaseChangeLog.class.getPackage().getName());
        runner.setSpringEnvironment(environment);
        return runner;
    }
}

