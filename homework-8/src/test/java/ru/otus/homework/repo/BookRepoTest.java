package ru.otus.homework.repo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.homework.config", "ru.otus.homework.repositories"})
@DisplayName("Repository для работы с книгами")
class BookRepoTest {
    private static final int COMMENT_ID = 1;
    private static final int BOOK_ID = 1;
    @Autowired
    private BookRepo bookRepo;

    @Test
    @DisplayName("корректное количество книг")
    void shouldReturnCorrectBookList() {
        val books = bookRepo.findAll();
        assertThat(books).isNotNull().hasSize(5);
    }

    @Test
    @DisplayName("корректно удалять комментарий из книги")
    void shouldCorrectDeleteCommentById() {
        bookRepo.deleteCommentById(COMMENT_ID);
        assertThat(bookRepo.findById(BOOK_ID).getComments()).hasSize(1);
    }

}
