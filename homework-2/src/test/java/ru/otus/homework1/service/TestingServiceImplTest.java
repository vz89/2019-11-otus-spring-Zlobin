package ru.otus.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@DisplayName("Класс TestingServiceImpl")
class TestingServiceImplTest {


    @DisplayName("корректно работают тестирование")
    @Test
    void shouldHaveCorrectTest() {
        int RIGHT_ANSWER=1;

        List<Question> questions = new ArrayList<Question>();
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("Синее");
        answers.add("Желтое");
        answers.add("Белое");
        answers.add("Красное");
        questions.add(new Question("Какого цвета небо?", answers, 1));


        Person person = new Person("Ivanov", "Petr");
        Testing testing = new Testing(person, questions);

        IOService ioServiceMock = mock(IOService.class);
        Mockito.when(ioServiceMock.read()).thenReturn("");
        Mockito.when(ioServiceMock.readInt()).thenReturn(RIGHT_ANSWER);
        doNothing().when(ioServiceMock).write("");

        MessageSource messageSource = mock(MessageSource.class);
        Locale locale = mock(Locale.class);

        TestingServiceImpl testingService = new TestingServiceImpl(ioServiceMock, messageSource, locale, 1);

        testingService.run(testing);

        assertTrue(testing.isResult());
    }

}