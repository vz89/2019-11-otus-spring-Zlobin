package ru.otus.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.repo.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author findByName(String authorName) {
        return authorRepository.findByName(authorName).orElse(null);
    }
}
