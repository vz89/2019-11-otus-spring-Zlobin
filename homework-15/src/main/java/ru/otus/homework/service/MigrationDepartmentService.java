package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Passport;

import java.util.Random;
import java.util.UUID;

@Service
public class MigrationDepartmentService {

    public Passport addMigrationRegistration(Passport passport) throws InterruptedException {
        System.out.println("Миграционный отдел ищет пользователя в своей базе данных");
        Thread.sleep(2000 + new Random().nextInt(10) * 100);

        passport.setMigrationId(UUID.randomUUID().toString());
        System.out.println("Миграционный отдел сделал отметку о пользователе");
        return passport;
    }
}
