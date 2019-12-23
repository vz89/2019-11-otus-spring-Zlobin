package ru.otus.homework.service;

import ru.otus.homework.domain.Person;

public interface PersonService {
    Person get(String firstName, String secondname);
}
