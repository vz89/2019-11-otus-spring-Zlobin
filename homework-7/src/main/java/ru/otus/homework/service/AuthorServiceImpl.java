package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.repo.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    final private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
                this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name).get();
    }


}
