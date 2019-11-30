package ru.otus.homework1.service;

import ru.otus.homework1.dao.QuestionDao;
import ru.otus.homework1.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;
    private String fileName;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuestions() {
        return questionDao.getQuestions(fileName);
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
