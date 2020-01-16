package ru.otus.homework.service;

import ru.otus.homework.domain.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author findById(long id);

    List<Author> findAll();

    Author findByName(String name);

}
