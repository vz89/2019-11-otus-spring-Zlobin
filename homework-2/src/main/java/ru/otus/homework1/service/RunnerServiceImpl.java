package ru.otus.homework1.service;

import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;

public class RunnerServiceImpl implements RunnerService {
    final private PersonService personService;
    final private QuestionService questionService;
    final private TestingService testingService;
    final private IOService ioService;

    public RunnerServiceImpl(PersonService personService, QuestionService questionService, TestingService testingService, IOService ioService) {
        this.personService = personService;
        this.questionService = questionService;
        this.testingService = testingService;
        this.ioService = ioService;
    }

    @Override
    public void run() {
        ioService.write("Введите ваше имя");
        String firstName = ioService.read();
        ioService.write("Введите вашу фамилию");
        String secondName = ioService.read();

        Person person = personService.get(firstName,secondName);
        List<Question> questions = questionService.getQuestions();
        Testing testing = testingService.createTest(person,questions);
        testingService.run(testing);
    }
}
