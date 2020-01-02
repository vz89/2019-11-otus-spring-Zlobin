package ru.otus.homework.service;

import ru.otus.homework.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre save (Genre genre);
    Optional<Genre> findById(long id);

    List<Genre> findAll();
    Genre findByName(String name);

    void updateNameById(long id);
    void deleteById(long id);
}
