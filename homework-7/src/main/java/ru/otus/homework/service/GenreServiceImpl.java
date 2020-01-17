package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repo.GenreRepository;

import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    final private GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Optional<Genre> findById(long id) {
        return genreRepository.findById(id);
    }


    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
}


