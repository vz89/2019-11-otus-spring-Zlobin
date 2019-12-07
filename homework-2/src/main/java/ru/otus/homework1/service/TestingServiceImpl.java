package ru.otus.homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.List;
import java.util.Locale;

@Service
public class TestingServiceImpl implements TestingService {
    private final IOService ioService;
    private final MessageSource messageSource;
    private final Locale locale;
    private final int minRightAnswers;

    @Autowired
    public TestingServiceImpl(IOService ioService, MessageSource messageSource, Locale locale, int minRightAnswers) {
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.locale = locale;
        this.minRightAnswers = minRightAnswers;
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
            ioService.write(messageSource.getMessage("test.question",null,locale) + currentQuestion + ": ");
            ioService.write(question.getQuestion());
            for (int i = 1; i <= question.getAnswers().size(); i++) {
                ioService.write(messageSource.getMessage("test.answer",null,locale) + i + ": " + question.getAnswers().get(i - 1));
            }
            ioService.write(messageSource.getMessage("test.getanswer",null,locale));
            boolean answerType = false;
            int answerIndex = 0;
            while (!answerType) {
                answerIndex = ioService.readInt();
                if (answerIndex < 1 || answerIndex > question.getAnswers().size()) {
                    answerType = false;
                    ioService.write(messageSource.getMessage("test.wrongnumber",null,locale) + question.getAnswers().size());
                } else answerType = true;
            }
            if (answerIndex != question.getRightAnswer()) {
                correctAnswers--;
            }
        }
        testing.setResult(correctAnswers >= minRightAnswers);
        String testResult = (testing.isResult()) ? messageSource.getMessage("test.passed",null,locale) : messageSource.getMessage("test.notpassed",null,locale);

        ioService.write(messageSource.getMessage("test.end",null,locale));
        ioService.write(messageSource.getMessage("test.results",null,locale));
        ioService.write(messageSource.getMessage("test.person",null,locale) + testing.getPerson().getSecondName() + " " + testing.getPerson().getFirstName());
        ioService.write(messageSource.getMessage("test.questioncount",null,locale) + testing.getQuestions().size());
        ioService.write(messageSource.getMessage("test.rightanswerscount",null,locale) + correctAnswers);
        ioService.write(messageSource.getMessage("test.test",null,locale) + testResult);

    }
}
