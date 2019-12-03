package ru.otus.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;
import ru.otus.homework1.service.PersonService;
import ru.otus.homework1.service.QuestionService;
import ru.otus.homework1.service.RunnerService;
import ru.otus.homework1.service.TestingService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        RunnerService runnerService = context.getBean(RunnerService.class);
        runnerService.run();
    }
}
