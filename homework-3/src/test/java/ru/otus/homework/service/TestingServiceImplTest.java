package ru.otus.homework.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.homework.config.ApplicationSettings;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Testing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

@DisplayName("Класс TestingServiceImpl")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class TestingServiceImplTest {

    @MockBean
    private IOService ioServiceMock;

    @MockBean
    private ApplicationSettings applicationSettings;

    @MockBean
    MessageSourceService messageSourceService;

    @Configuration
    class TestConfiguration {
        @Bean
        public TestingService testingService() {
            return new TestingServiceImpl(ioServiceMock, applicationSettings, messageSourceService);
        }
    }

    @Autowired
    TestingService testingService;

    @DisplayName("корректно работает тестирование")
    @Test
    void shouldHaveCorrectTest() {
        int RIGHT_ANSWER = 1;

        List<Question> questions = new ArrayList<Question>();
        List<String> answers = new ArrayList<String>();
        answers.add("Синее");
        answers.add("Желтое");
        answers.add("Белое");
        answers.add("Красное");

        questions.add(new Question("Какого цвета небо?", answers, RIGHT_ANSWER));

        Person person = new Person("Ivanov", "Petr");
        Testing testing = new Testing(person, questions);

        Mockito.when(ioServiceMock.read()).thenReturn("");
        Mockito.when(ioServiceMock.readInt()).thenReturn(RIGHT_ANSWER);
        doNothing().when(ioServiceMock).write("");

        testingService.run(testing);

        assertTrue(testing.isResult());
    }

}