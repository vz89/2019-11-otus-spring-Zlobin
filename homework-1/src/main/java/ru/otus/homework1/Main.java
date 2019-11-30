package ru.otus.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;
import ru.otus.homework1.service.PersonService;
import ru.otus.homework1.service.QuestionService;
import ru.otus.homework1.service.TestingService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        System.out.println("¬ведите им€");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        System.out.println("¬ведите фамилию");
        String secondName = sc.nextLine();

        PersonService personService = context.getBean(PersonService.class);
        Person person = personService.get(firstName,secondName);

        QuestionService questionService = context.getBean(QuestionService.class);
        List<Question> questions = questionService.getQuestions();

        TestingService testingService = context.getBean(TestingService.class);
        Testing testing = testingService.createTest(person,questions);
        testingService.run(testing);
        

    }
}
