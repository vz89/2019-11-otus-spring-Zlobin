package ru.otus.homework.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;

@MessagingGateway
public interface PassportForUserGateway {

    @Gateway(requestChannel = "userChannel", replyChannel = "passportChannel")
    Passport process(User user);
}
