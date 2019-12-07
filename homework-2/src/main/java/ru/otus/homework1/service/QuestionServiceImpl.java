package ru.otus.homework1.service;

import ru.otus.homework1.dao.QuestionDao;
import ru.otus.homework1.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    final private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

}
