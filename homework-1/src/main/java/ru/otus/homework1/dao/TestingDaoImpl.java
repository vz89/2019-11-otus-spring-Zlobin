package ru.otus.homework1.dao;

import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;

public class TestingDaoImpl implements TestingDao {
    public Testing create(Person person, List<Question> questionList) {
        return new Testing(person, questionList);
    }
}
