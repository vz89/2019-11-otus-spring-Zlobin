package ru.otus.homework1.service;

import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;

public class TestingServiceImpl implements TestingService {
    private final IOService ioService;

    public TestingServiceImpl(IOService ioService) {

        this.ioService = ioService;
    }

    public Testing createTest(Person person, List<Question> questions) {
        return  new Testing(person, questions);
    }

    public void run(Testing testing) {
        ioService.write("");
        int correctAnswers = testing.getQuestions().size();
        int currentQuestion = 0;
        for (Question question : testing.getQuestions()
        ) {
            currentQuestion++;
            ioService.write("Вопрос №" + currentQuestion + ": ");
            ioService.write(question.getQuestion());
            for (int i = 1; i <= question.getAnswers().size(); i++) {
                ioService.write("Ответ №" + i + ": " + question.getAnswers().get(i - 1));
            }
            ioService.write("Введите вариант ответа цифрой от 1 до 4 ");
            boolean answerType = false;
            int answerIndex = 0;
            while (!answerType) {
                answerIndex = ioService.readInt();
                if (answerIndex < 1 || answerIndex > question.getAnswers().size()) {
                    answerType = false;
                    ioService.write("Введите цифру от 1 до " + question.getAnswers().size());
                } else answerType = true;
            }
            if (answerIndex != question.getRightAnswer()) {
                correctAnswers--;
            }
        }
        testing.setResult(correctAnswers > testing.getQuestions().size() / 2);
        String testResult = (testing.isResult()) ? "Пройден" : "не пройден";

        ioService.write("Tecт окончен!");
        ioService.write("Результаты:");
        ioService.write("Тестируемый: " + testing.getPerson().getSecondName() + " " + testing.getPerson().getFirstName());
        ioService.write("Количество вопросов: " + testing.getQuestions().size());
        ioService.write("Количество правильных ответов: " + correctAnswers);
        ioService.write("Тест: " + testResult);

    }
}
