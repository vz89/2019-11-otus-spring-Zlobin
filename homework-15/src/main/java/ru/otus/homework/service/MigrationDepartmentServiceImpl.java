package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;

@Service
public class MigrationDepartmentServiceImpl implements MigrationDepartmentService {

    @Override
    public Passport message(User user) {
        return new Passport(user.getName());
    }
}
