package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Testing;

import java.util.List;
import java.util.Locale;

@Service
public class RunnerServiceImpl implements RunnerService {
    final private PersonService personService;
    final private QuestionService questionService;
    final private TestingService testingService;
    final private IOService ioService;
    final private MessageSourceService messageSourceService;

    @Autowired
    public RunnerServiceImpl(PersonService personService, QuestionService questionService,
                             TestingService testingService, IOService ioService, MessageSourceService messageSourceService) {
        this.personService = personService;
        this.questionService = questionService;
        this.testingService = testingService;
        this.ioService = ioService;
        this.messageSourceService = messageSourceService;

    }

    @Override
    public void run() {
        ioService.write(messageSourceService.getMessage("person.firstname"));
        String firstName = ioService.read();
        ioService.write(messageSourceService.getMessage("person.secondname"));
        String secondName = ioService.read();

        Person person = personService.get(firstName, secondName);
        List<Question> questions = questionService.getQuestions();
        Testing testing = testingService.createTest(person, questions);
        testingService.run(testing);
    }
}
