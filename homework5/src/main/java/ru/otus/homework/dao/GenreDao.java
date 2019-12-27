package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;

@Repository
public interface GenreDao {


    void insert(Genre genre);
    Genre getById(long id);
    boolean checkByName(String genreName);
    Genre getByName(String genreName);
}
