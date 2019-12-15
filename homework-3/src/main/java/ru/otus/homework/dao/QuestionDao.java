package ru.otus.homework.dao;

import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.CSVFileReadingFailedException;
import ru.otus.homework.exception.InvalidCsvDataException;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws CSVFileReadingFailedException;
}
