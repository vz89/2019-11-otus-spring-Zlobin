package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;

import java.util.Random;
import java.util.UUID;

@Service
public class RegistrationDepartmentService {
    public Passport addRegistration(User user) throws InterruptedException {
        System.out.println("УФМС ищет пользователя в своей базе данных");
        Thread.sleep(2000 + new Random().nextInt(10) * 100);

        Passport passport = new Passport(user.getName());
        passport.setRegistrationId(UUID.randomUUID().toString());
        System.out.println("УФМС сделал отметку о пользователе");
        return passport;
    }
}
