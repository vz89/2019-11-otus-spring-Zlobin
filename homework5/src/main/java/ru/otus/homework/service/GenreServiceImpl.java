package ru.otus.homework.service;

import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Genre;

public class GenreServiceImpl implements GenreService{
    final private GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Genre getById(long id) {
        return genreDao.getById(id);
    }
}
