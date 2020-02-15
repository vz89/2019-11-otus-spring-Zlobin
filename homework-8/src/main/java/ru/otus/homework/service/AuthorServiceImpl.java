package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.dto.AuthorBookCountAggregateResult;
import ru.otus.homework.repo.AuthorRepo;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final SequenceGeneratorService sequenceGeneratorService;

    public AuthorServiceImpl(AuthorRepo authorRepo, SequenceGeneratorService sequenceGeneratorService) {
        this.authorRepo = authorRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Author getAuthor(String authorName) {
        Author author = authorRepo.findByName(authorName);
        if (author == null) {
            return authorRepo.save(new Author(sequenceGeneratorService.generateSequence(Author.SEQUENCE_NAME), authorName));
        } else return author;
    }

    @Override
    public Author findById(long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount() {
        return authorRepo.findAllAuthorsWithBooksCount();
    }
}
