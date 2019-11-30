package ru.otus.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.homework1.dao.TestingDao;
import ru.otus.homework1.domain.Person;
import ru.otus.homework1.domain.Question;
import ru.otus.homework1.domain.Testing;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@DisplayName("Класс TestingServiceImpl")
public class TestServiceImplTest {

    @Test
    void shouldHaveCorrectTest() {

        List<Question> questions = new ArrayList<Question>();
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("Синее");
        answers.add("Желтое");
        answers.add("Белое");
        answers.add("Красное");
        questions.add(new Question("Какого цвета небо?", answers, 1));

        Person personMock = mock(Person.class);
        Testing testing = new Testing(personMock, questions);
        TestingDao testingDaoMock = mock(TestingDao.class);

        TestingServiceImpl testService = new TestingServiceImpl(testingDaoMock);

        testService.run(testing);

    }

}