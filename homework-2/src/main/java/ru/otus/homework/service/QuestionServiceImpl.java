package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.InvalidCsvDataException;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    final private QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuestions() {
        List<Question> questions = null;
        try {
            questions = questionDao.getQuestions();
        } catch (InvalidCsvDataException e) {
            e.getMessage();
        }
        return questions;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

}
