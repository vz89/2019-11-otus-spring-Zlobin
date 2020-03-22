package ru.otus.homework.service;

import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;

public interface MigrationDepartmentService {
    Passport message(User user);
}
