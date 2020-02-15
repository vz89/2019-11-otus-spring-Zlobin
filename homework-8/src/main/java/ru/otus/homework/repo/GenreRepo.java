package ru.otus.homework.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.homework.domain.Genre;

public interface GenreRepo extends MongoRepository<Genre,Long> {
    Genre findByName(String name);
}
