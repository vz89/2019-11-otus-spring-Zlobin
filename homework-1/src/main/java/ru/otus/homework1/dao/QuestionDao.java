package ru.otus.homework1.dao;

import ru.otus.homework1.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions();
}
