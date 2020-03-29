package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Passport;

import java.util.Random;
import java.util.UUID;

@Service
public class RegistryWeddingDepartmentService {
    public Passport addWeddingRegistry(Passport passport) throws InterruptedException {
        System.out.println("ЗАГС ищет пользователя в своей базе данных");
        Thread.sleep(2000 + new Random().nextInt(10) * 100);

        passport.setMaritalStatus(UUID.randomUUID().toString());
        System.out.println("ЗАГС сделал отметку о пользователе");
        return passport;
    }
}
