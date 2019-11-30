package ru.otus.homework1.service;

import ru.otus.homework1.dao.PersonDao;
import ru.otus.homework1.domain.Person;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person get(String firstName, String secondName) {
        return personDao.find(firstName, secondName);
    }
}
