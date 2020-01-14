package ru.otus.homework.dao;

import ru.otus.homework.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    Author save (Author author);
    Optional<Author> findById(long id);

    List<Author> findAll();
    Author findByName(String name);
}
