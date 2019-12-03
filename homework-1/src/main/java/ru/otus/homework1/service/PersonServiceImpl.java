package ru.otus.homework1.service;

import ru.otus.homework1.domain.Person;

public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {

    }

    public Person get(String firstName, String secondName) {
        return new Person(firstName, secondName);
    }
}
