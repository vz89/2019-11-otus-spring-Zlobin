package ru.otus.homework.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.domain.Task;

@MessagingGateway
public interface Work {

    @Gateway(requestChannel = "userChannel", replyChannel = "passportChannel")
    Task process(Task task);
}
