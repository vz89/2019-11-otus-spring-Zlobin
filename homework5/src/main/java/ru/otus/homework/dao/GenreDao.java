package ru.otus.homework.dao;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.List;

public interface GenreDao {
    int getCount();
    void insert(Genre genre);
    Genre getById(long id);
    List<Genre> getAll();
    void deleteById(long id);

    Genre getByName(String genreName);
}
