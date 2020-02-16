package ru.otus.homework.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.homework.domain.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
        Flux<Book> findAll();

}

