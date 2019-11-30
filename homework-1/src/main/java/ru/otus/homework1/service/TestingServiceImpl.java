package ru.otus.homework1.service;

import ru.otus.homework1.dao.TestingDao;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {
    private TestingDao testingDao;
    private Scanner sc = new Scanner(System.in);

    public TestingServiceImpl(TestingDao testingDao) {
        this.testingDao = testingDao;
    }

    public Testing createTest(Person person, List<Question> questionsByFileName) {
        return testingDao.create(person, questionsByFileName);
    }

    public void run(Testing testing) {
        System.out.println();
        int correctAnswers = testing.getQuestions().size();
        int currentQuestion = 0;
        for (Question question : testing.getQuestions()
        ) {
            currentQuestion++;
            System.out.print("Вопрос №" + currentQuestion + ": ");
            System.out.println(question.getQuestion());
            for (int i = 1; i <= question.getAnswers().size(); i++) {
                System.out.print("Вариант ответа №" + i + ": ");
                System.out.println(question.getAnswers().get(i - 1));
            }

            System.out.println("Введите свой вариант ответа цифрой от 1 до 4");
            boolean answerType = false;
            int answerIndex = 0;
            while (!answerType) {
                answerIndex = sc.nextInt();
                if (answerIndex < 1 || answerIndex > question.getAnswers().size()) {
                    answerType = false;
                    System.out.print(" Введите цифру от 1 до " + question.getAnswers().size());
                } else answerType = true;
            }
            if (answerIndex != question.getRightAnswer()) {
                correctAnswers--;
            }
        }
        testing.setResult(correctAnswers >= testing.getQuestions().size() / 2);
        String testResult = (testing.isResult()) ? "пройден" : "не пройден";

        System.out.println("Tecт окончен!");
        System.out.println("Результаты теста:");
        System.out.println("Тестируемый: " + testing.getPerson().getSecondName() + " " + testing.getPerson().getFirstName());
        System.out.println("Количество вопросов: " + testing.getQuestions().size());
        System.out.println("Правильных ответов: " + correctAnswers);
        System.out.println("Тест " + testResult);
    }


    public TestingDao getTestingDao() {
        return testingDao;
    }

    public void setTestingDao(TestingDao testingDao) {
        this.testingDao = testingDao;
    }
}
