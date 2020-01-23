package ru.otus.homework.repo;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.homework.bee.changelog.DatabaseChangeLog;


@DataMongoTest
@ExtendWith(SpringExtension.class)
class BookRepoTest {
    @Autowired
    private MongoClient mongo;


    @Test
    void shouldStartTest() {

    }


}
