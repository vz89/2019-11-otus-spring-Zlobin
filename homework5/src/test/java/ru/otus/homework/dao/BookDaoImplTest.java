package ru.otus.homework.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.ArrayList;
import java.util.List;


@DisplayName("Dao для работы с книгами")
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BookDaoImpl.class)
class BookDaoImplTest {

    private static final int EXPECTED_BOOKS_COUNT = 3;

    private static final String NEW_BOOK_TITLE = "new book";
    private static final long NEW_BOOK_ID = 4;
    private static final long GET_BOOK_ID = 1;
    @Autowired
    private BookDaoImpl bookDao;

    @DisplayName("возращать правильное количество книг")
    @Test
    void shouldReturnCorrectBookCount() {
        Assertions.assertThat(bookDao.getCount()).isEqualTo(EXPECTED_BOOKS_COUNT);
    }

    @DisplayName("добавлять книгу в БД")
    @Test
    void shouldInsertBook() {
        Book book = new Book(NEW_BOOK_ID, NEW_BOOK_TITLE, new Author(new Long(1),"Достоевский"), new Genre(new Long(2),"Комедия"));
        bookDao.insert(book);
        Book actualBook = bookDao.getById(NEW_BOOK_ID);
        Assertions.assertThat(actualBook).isEqualTo(book);
    }

    @DisplayName("получать нужную книгу по Id")
    @Test
    void shouldReturnCorrectBookById() {
        Book book = new Book(GET_BOOK_ID, "Идиот", new Author(new Long(1), "Достоевский"), new Genre(new Long(1), "Роман"));
        Book actualBook = bookDao.getById(GET_BOOK_ID);
        Assertions.assertThat(actualBook).isEqualTo(book);
    }

    @DisplayName("получить все книги")
    @Test
    void shouldReturnCorrectBookList() {
        Book book1 = new Book(new Long(1), "Идиот", new Author(new Long(1), "Достоевский"), new Genre(new Long(1), "Роман"));
        Book book2 = new Book(new Long(2), "Горе от ума", new Author(new Long(2), "Грибоедов"), new Genre(new Long(2), "Комедия"));
        Book book3 = new Book(new Long(3), "Шерлок Холмс", new Author(new Long(3), "Конан Дойл"), new Genre(new Long(3), "Детектив"));
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        List<Book> actualBooks = bookDao.getAll();
        Assertions.assertThat(actualBooks).isEqualTo(books);
    }

}
