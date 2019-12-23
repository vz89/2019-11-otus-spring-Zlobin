package ru.otus.homework.dao;

import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.QuestionsReadingFailedException;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws QuestionsReadingFailedException;
}
