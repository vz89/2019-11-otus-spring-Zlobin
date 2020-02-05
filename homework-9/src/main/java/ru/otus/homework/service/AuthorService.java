package ru.otus.homework.service;

import ru.otus.homework.domain.Author;

public interface AuthorService {
    Author findByName(String authorName);
}
