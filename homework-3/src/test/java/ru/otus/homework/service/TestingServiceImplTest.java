package ru.otus.homework.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.homework.config.ApplicationSettings;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Testing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@DisplayName("Класс TestingServiceImpl")
class TestingServiceImplTest {


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

        questions.add(new Question("Какого цвета небо?", answers, 1));

        Person person = new Person("Ivanov", "Petr");
        Testing testing = new Testing(person, questions);

        IOService ioServiceMock = mock(IOService.class);
        ApplicationSettings applicationConfig = mock(ApplicationSettings.class);
        MessageSourceService messageSourceService = mock(MessageSourceService.class);

        Mockito.when(ioServiceMock.read()).thenReturn("");
        Mockito.when(ioServiceMock.readInt()).thenReturn(RIGHT_ANSWER);
        doNothing().when(ioServiceMock).write("");

        TestingServiceImpl testingService = new TestingServiceImpl(ioServiceMock, applicationConfig, messageSourceService);

        testingService.run(testing);

        assertTrue(testing.isResult());
    }

}