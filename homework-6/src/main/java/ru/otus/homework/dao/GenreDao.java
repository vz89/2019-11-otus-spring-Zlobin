package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreDao {
    Genre save (Genre genre);
    Optional<Genre> findById(long id);

    List<Genre> findAll();
    List<Genre> findByName(String name);

    void updateNameById(long id);
    void deleteById(long id);
}
