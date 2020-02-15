package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repo.GenreRepo;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepo genreRepo;
    private final SequenceGeneratorService sequenceGeneratorService;

    public GenreServiceImpl(GenreRepo genreRepo, SequenceGeneratorService sequenceGeneratorService) {
        this.genreRepo = genreRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Genre getGenre(String genreName) {
        Genre genre = genreRepo.findByName(genreName);
        if (genre == null) {
            return genreRepo.save(new Genre(sequenceGeneratorService.generateSequence(Genre.SEQUENCE_NAME), genreName));
        } else return genre;
    }
}
