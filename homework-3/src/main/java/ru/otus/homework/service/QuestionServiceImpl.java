package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.QuestionDao;
import ru.otus.homework.domain.Question;
import ru.otus.homework.exception.QuestionsReadingFailedException;

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
            questions= questionDao.getQuestions();
        } catch (QuestionsReadingFailedException e) {
            e.printStackTrace();
        }
        return questions;
    }



}
