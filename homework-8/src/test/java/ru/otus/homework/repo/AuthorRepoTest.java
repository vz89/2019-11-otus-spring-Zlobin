package ru.otus.homework.repo;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.homework.config", "ru.otus.homework.repositories"})
@DisplayName("Repository для работы с авторами")
class AuthorRepoTest {

    private static final long BOOK_ID = 1;
    private static final long AUTHOR_ID = 1;
    private static final int AUTHOR1_BOOK_COUNT = 2;
    private static final long AUTHOR2_ID=2;
    private static final int AUTHOR2_BOOK_COUNT=2;
    private static final long AUTHOR3_ID=3;
    private static final int AUTHOR3_BOOK_COUNT=1;

    @Autowired
    private AuthorRepo authorRepo;

    @Test
    @DisplayName("корректно удалять книгу у автора")
    void shouldCorrectDeleteCommentById() {
        authorRepo.deleteBookById(BOOK_ID);
        assertThat(authorRepo.findById(AUTHOR_ID).get().getBooks()).hasSize(1);
    }

    @Test
    @DisplayName("корректно выводить число книг у авторов")
    void shouldHaveCorrectAuthorsBookCount() {
        List<AuthorBookCountAggregateResult> actual = authorRepo.findAllAuthorsWithBooksCount();
        assertThat(actual).hasSize(3);
        List<AuthorBookCountAggregateResult> expected = new ArrayList();
        expected.add(new AuthorBookCountAggregateResult(authorRepo.findById(AUTHOR3_ID).get(), AUTHOR3_BOOK_COUNT));
        expected.add(new AuthorBookCountAggregateResult(authorRepo.findById(AUTHOR2_ID).get(), AUTHOR2_BOOK_COUNT));
        expected.add(new AuthorBookCountAggregateResult(authorRepo.findById(AUTHOR_ID).get(), AUTHOR1_BOOK_COUNT));
        Assert.assertEquals(actual,expected);
    }

}
