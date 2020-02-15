package ru.otus.homework.repo;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.otus.homework.domain.Author;
import ru.otus.homework.dto.AuthorBookCountAggregateResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.homework.config", "ru.otus.homework.repositories"})
@DisplayName("Repository для работы с авторами")
class AuthorRepoTest {

    private static final long AUTHOR_ID = 1;
    private static final int AUTHOR1_BOOK_COUNT = 2;
    private static final long AUTHOR2_ID=2;
    private static final int AUTHOR2_BOOK_COUNT=2;
    private static final long AUTHOR3_ID=3;
    private static final int AUTHOR3_BOOK_COUNT=1;
    private static final int ACTUAL_AUTHOR_BOOK_COUNT_AGGREGATE_LIST_SIZE = 3;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    MongoOperations mongoOperations;

    @Test
    @DisplayName("корректно выводить число книг у авторов")
    void shouldHaveCorrectAuthorsBookCount() {
        List<AuthorBookCountAggregateResult> actual = authorRepo.findAllAuthorsWithBooksCount();
        assertThat(actual).hasSize(ACTUAL_AUTHOR_BOOK_COUNT_AGGREGATE_LIST_SIZE);
        List<AuthorBookCountAggregateResult> expected = new ArrayList();
        expected.add(new AuthorBookCountAggregateResult(mongoOperations.findOne(searchAuthor(AUTHOR3_ID), Author.class), AUTHOR3_BOOK_COUNT));
        expected.add(new AuthorBookCountAggregateResult(mongoOperations.findOne(searchAuthor(AUTHOR2_ID),Author.class), AUTHOR2_BOOK_COUNT));
        expected.add(new AuthorBookCountAggregateResult(mongoOperations.findOne(searchAuthor(AUTHOR_ID),Author.class), AUTHOR1_BOOK_COUNT));
        Assert.assertEquals(actual,expected);
    }

    private Query searchAuthor(long id) {
        return new Query(Criteria.where("Id").is(id));
    }


}
