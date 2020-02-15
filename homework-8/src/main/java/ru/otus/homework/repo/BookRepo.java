package ru.otus.homework.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookRepo extends MongoRepository<Book, Long>,BookRepoCustom{

    Book findById(long id);
    List<Book> findAllByTitle(String title);
    List<Book> findAllByAuthorId(long id);
}
