package ru.otus.homework.service;

import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.InvalidCsvDataException;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();
}
