package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;

import java.util.Optional;

@Repository
public interface GenreDao {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    Genre findByName(String name);

}
