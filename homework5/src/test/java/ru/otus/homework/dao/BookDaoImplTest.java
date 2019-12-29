package ru.otus.homework.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Dao для работы с книгами")
@ExtendWith(SpringExtension.class)
@JdbcTest
@Import(BookDaoImpl.class)
class BookDaoImplTest {

    @Autowired
    private BookDaoImpl bookDao;

    @DisplayName("возращать правильное количество книг")
    @Test
    void shouldReturnCorrectBookCount() {

    }

    @DisplayName("добавлять книгу в БД")
    @Test
    void shouldInsertBook() {

    }

    @DisplayName("получать нужную книгу по Id")
    @Test
    void shouldReturnCorrectBookById() {

    }

    @DisplayName("получить все книги")
    @Test
    void shouldReturnCorrectBookList() {

    }

    @DisplayName("удалить книгу по Id")
    @Test
    void shouldDeleteCorrectBookById() {

    }


}
