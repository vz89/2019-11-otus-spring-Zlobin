package ru.otus.homework.service;

import ru.otus.homework.domain.Genre;

public interface GenreService {
    Genre findByName(String genreName);
}
