package ru.otus.homework1.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.homework1.domain.Person;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс Person")
class PersonTest {

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Person person = new Person("Shawn", "Michaels");

        assertAll(
                "person",
                () -> assertEquals("Shawn", person.getFirstName()),
                () -> assertEquals("Michaels", person.getSecondName())
        );
    }

    @DisplayName("корректно работают сеттеры")
    @Test
    void shouldHaveCorrectSetters() {
        final Person person = new Person("Shawn", "Michaels");
        person.setFirstName("John");
        person.setSecondName("Snow");
        assertAll(
                "person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Snow", person.getSecondName())
        );

    }
}
