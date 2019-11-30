package ru.otus.homework1.service;

import ru.otus.homework1.domain.Person;

public interface PersonService {
    Person get(String firstName, String secondname);
}
