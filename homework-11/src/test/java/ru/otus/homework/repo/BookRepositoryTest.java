package ru.otus.homework.repo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.homework.config", "ru.otus.homework.repo"})
@DisplayName("Repository для работы с книгами")
class BookRepositoryTest {

    private static final String BOOK_TITLE = "Book";
    private static final String AUTHOR_TITLE = "Author";
    private static final String AUTHOR_NAME = AUTHOR_TITLE;
    private static final String GENRE_NAME = "genre";
    private static final String BOOK_1 = "book1";
    private static final String BOOK_2 = "book2";
    private static final String BOOK_3 = "book3";
    private static final String BOOK_4 = "book4";
    private static final String BOOK_5 = "book5";
    private static final String BOOK_ID = "1";
    @Autowired
    private BookRepository repository;

    @Test
    @DirtiesContext
    void shouldSetIdOnSave() {
        Mono<Book> bookMono = repository.save(new Book(BOOK_TITLE, new Author(AUTHOR_NAME), new Genre(GENRE_NAME), null));

        StepVerifier
                .create(bookMono)
                .assertNext(book -> assertNotNull(book.getId()))
                .expectComplete()
                .verify();
    }


    @Test
    void shouldReturnAllCorrectBooks() {
        Flux<Book> bookFlux = repository.findAll();

        StepVerifier
                .create(bookFlux)
                .recordWith(ArrayList::new)
                .expectNextCount(5)
                .consumeRecordedWith(results -> {
                    assertThat(results)
                            .extracting(Book::getTitle)
                            .contains(BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5);
                })
                .verifyComplete();
    }

    @Test
    void shouldFindAllBooks() {
        StepVerifier.create(repository.findAll())
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void shouldFindCorrectBookById() {
        Mono<Book> monoBook = repository.findById(BOOK_ID);

        StepVerifier.create(monoBook)
                .assertNext((book -> assertEquals(book.getTitle(), BOOK_1)))
                .expectComplete()
                .verify();

    }


}
