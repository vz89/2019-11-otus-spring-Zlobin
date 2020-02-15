package ru.otus.homework.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.homework.domain.Author;

public interface AuthorRepo extends MongoRepository<Author,Long>,AuthorRepoCustom{
    Author findByName(String name);
}
