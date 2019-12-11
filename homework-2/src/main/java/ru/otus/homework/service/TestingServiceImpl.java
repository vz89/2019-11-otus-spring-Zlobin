package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.ApplicationConfig;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Testing;

import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {
    private final IOService ioService;
    private final ApplicationConfig applicationConfig;
    private final MessageSourceService messageSourceService;


    @Autowired
    public TestingServiceImpl(IOService ioService, ApplicationConfig applicationConfig, MessageSourceService messageSourceService) {
        this.ioService = ioService;
        this.applicationConfig = applicationConfig;
        this.messageSourceService = messageSourceService;
    }

    public Testing createTest(Person person, List<Question> questions) {
        return  new Testing(person, questions);
    }

    public void run(Testing testing) {
        int correctAnswers = testing.getQuestions().size();
        int currentQuestion = 0;
        for (Question question : testing.getQuestions()
        ) {
            currentQuestion++;
            ioService.write(messageSourceService.getMessage("test.question") + currentQuestion + ": ");
            ioService.write(question.getQuestion());
            for (int i = 1; i <= question.getAnswers().size(); i++) {
                ioService.write(messageSourceService.getMessage("test.answer") + i + ": " + question.getAnswers().get(i - 1));
            }
            ioService.write(messageSourceService.getMessage("test.getanswer"));
            boolean answerType = false;
            int answerIndex = 0;
            while (!answerType) {
                answerIndex = ioService.readInt();
                if (answerIndex < 1 || answerIndex > question.getAnswers().size()) {
                    answerType = false;
                    ioService.write(messageSourceService.getMessage("test.wrongnumber") + question.getAnswers().size());
                } else answerType = true;
            }
            if (answerIndex != question.getRightAnswer()) {
                correctAnswers--;
            }
        }
        testing.setResult(correctAnswers >= applicationConfig.getMinRightAnswer());
        String testResult = (testing.isResult()) ? messageSourceService.getMessage("test.passed") : messageSourceService.getMessage("test.notpassed");

        ioService.write(messageSourceService.getMessage("test.end"));
        ioService.write(messageSourceService.getMessage("test.results"));
        ioService.write(messageSourceService.getMessage("test.person") + testing.getPerson().getSecondName() + " " + testing.getPerson().getFirstName());
        ioService.write(messageSourceService.getMessage("test.questioncount") + testing.getQuestions().size());
        ioService.write(messageSourceService.getMessage("test.rightanswerscount") + correctAnswers);
        ioService.write(messageSourceService.getMessage("test.test") + testResult);

    }
}
