package ru.otus.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;
import java.util.Locale;

@Service
public class RunnerServiceImpl implements RunnerService {
    final private PersonService personService;
    final private QuestionService questionService;
    final private TestingService testingService;
    final private IOService ioService;
    final private MessageSource messageSource;
    final private Locale locale;

    @Autowired
    public RunnerServiceImpl(PersonService personService, QuestionService questionService,
                             TestingService testingService, IOService ioService, MessageSource messageSource, Locale locale) {
        this.personService = personService;
        this.questionService = questionService;
        this.testingService = testingService;
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public void run() {
        ioService.write(messageSource.getMessage("person.firstname", null, locale));
        String firstName = ioService.read();
        ioService.write(messageSource.getMessage("person.secondname", null, locale));
        String secondName = ioService.read();

        Person person = personService.get(firstName, secondName);
        List<Question> questions = questionService.getQuestions();
        Testing testing = testingService.createTest(person, questions);
        testingService.run(testing);
    }
}
