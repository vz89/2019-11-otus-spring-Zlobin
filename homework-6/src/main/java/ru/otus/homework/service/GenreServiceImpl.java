package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    final private GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Genre save(Genre genre) {
        return genreDao.save(genre);
    }

    @Override
    public Optional<Genre> findById(long id) {
        return genreDao.findById(id);
    }


    @Override
    public Genre findByName(String name) {
        return genreDao.findByName(name);
    }
}


