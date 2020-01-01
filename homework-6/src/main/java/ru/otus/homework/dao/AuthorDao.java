package ru.otus.homework.dao;

import ru.otus.homework.domain.Author;

public interface AuthorDao {
    void insert(Author genre);
    Author getById(long id);
    boolean checkByName(String genreName);
    Author getByName(String genreName);
}
