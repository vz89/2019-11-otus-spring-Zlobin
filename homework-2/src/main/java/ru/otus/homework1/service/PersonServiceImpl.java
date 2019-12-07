package ru.otus.homework1.service;

import org.springframework.stereotype.Service;
import ru.otus.homework1.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {

    }

    public Person get(String firstName, String secondName) {
        return new Person(firstName, secondName);
    }
}
