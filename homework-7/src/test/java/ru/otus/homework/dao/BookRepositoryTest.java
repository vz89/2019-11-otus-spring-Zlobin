package ru.otus.homework.dao;

import lombok.val;
import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repo.BookRepository;
import ru.otus.homework.repo.CommentRepository;
import ru.otus.homework.service.BookService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Dao для работы с книгами")
@DataJpaTest
class BookRepositoryTest {

    private static final int EXPECTED_BOOK_COUNT = 4;
    private static final int EXPECTED_NUMBER_OF_BOOKS = 4;
    private static final long FIRST_BOOK_ID = 1;
    private static final String NEW_BOOK_TITLE = "new book";
    private static final String FIRST_BOOK_NAME = "Идиот";
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("должен корректно сохранять книгу в бд")
    @Test
    void shouldSaveBook() {
        val author = new Author("Гоголь");
        val genre = new Genre("Пьеса");
        var book = new Book(NEW_BOOK_TITLE, author, genre);
        book = bookRepository.save(book);

        assertThat(book.getId()).isGreaterThan(0);

        val actualBook = em.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthor() != null)
                .matches(b -> b.getGenre() != null);
    }

    @DisplayName("должен загружать информацию о нужной книге по её Id")
    @Test
    void shouldFindBookById() {
        val optionalActualBook = bookRepository.findById(FIRST_BOOK_ID);
        val expectedBook = em.find(Book.class, FIRST_BOOK_ID);
        assertThat(optionalActualBook).isPresent().get().isEqualTo(expectedBook);
    }

    @DisplayName("должен загружать список всех книг с информацией об авторе и жанре")
    @Test
    void shouldReturnCorrectBookListWithGenreAndAuthor() {
        val books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(book -> !book.getTitle().equals(""))
                .allMatch(book -> book.getGenre() != null)
                .allMatch(book -> book.getAuthor() != null);
    }

    @DisplayName(" должен загружать информацию о нужной книге по ее имени")
    @Test
    void shouldFindBookByName() {
        val firstBook = em.find(Book.class, FIRST_BOOK_ID);
        List<Book> books = bookRepository.findBooksByTitle(FIRST_BOOK_NAME);
        assertThat(books).containsOnlyOnce(firstBook);
    }

    @DisplayName(" должен изменять наименование нужной книге по ее Id")
    @Test
    void shouldUpdateBookNameById() {
        val firstBook = em.find(Book.class, FIRST_BOOK_ID);
        String oldName = firstBook.getTitle();
        em.clear();

        bookRepository.updateNameById(FIRST_BOOK_ID, NEW_BOOK_TITLE);
        val updatedBook = em.find(Book.class, FIRST_BOOK_ID);

        assertThat(updatedBook.getTitle()).isNotEqualTo(oldName).isEqualTo(NEW_BOOK_TITLE);
    }

    @DisplayName(" должен удалять нужную книгу по ее Id")
    @Test
    void shouldDeleteBookNameById() {
        em.clear();
        bookRepository.deleteById(FIRST_BOOK_ID);
        val deletedBook = em.find(Book.class, FIRST_BOOK_ID);
        assertThat(deletedBook).isNull();
    }

    @DisplayName(" должен выводить правильное количество книг")
    @Test
    void shouldReturnCorrectBookCount() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(EXPECTED_BOOK_COUNT);
    }


}
