package ru.otus.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework1.dao.QuestionDao;
import ru.otus.homework1.domain.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    final private QuestionDao questionDao;

    @Autowired
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
