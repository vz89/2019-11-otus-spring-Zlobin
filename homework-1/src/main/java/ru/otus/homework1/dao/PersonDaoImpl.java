package ru.otus.homework1.dao;

import ru.otus.homework1.domain.Person;

public class PersonDaoImpl implements PersonDao {
    public Person find(String firstName, String secondName) {
        return new Person(firstName, secondName);
    }
}
