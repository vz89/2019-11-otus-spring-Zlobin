package ru.otus.homework.service;

import ru.otus.homework.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save (Author author);
    Optional<Author> findById(long id);

    List<Author> findAll();
    Author findByName(String name);

    void updateNameById(long id);
    void deleteById(long id);
}
