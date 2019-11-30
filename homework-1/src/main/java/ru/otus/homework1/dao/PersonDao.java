package ru.otus.homework1.dao;

import ru.otus.homework1.domain.Person;

public interface PersonDao {
    Person find(String firstName, String secondName);
}
