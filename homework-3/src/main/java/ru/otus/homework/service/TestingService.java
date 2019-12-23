package ru.otus.homework.service;

import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Testing;

import java.util.List;

public interface TestingService {

    Testing createTest(Person person, List<Question> questionsByFileName);

    void run(Testing testing);
}
