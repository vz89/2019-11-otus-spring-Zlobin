package ru.otus.homework1.service;

import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;

public interface TestingService {

    Testing createTest(Person person, List<Question> questionsByFileName);

    void run(Testing testing);
}
