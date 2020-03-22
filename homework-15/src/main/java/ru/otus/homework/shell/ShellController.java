package ru.otus.homework.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;
import ru.otus.homework.integration.ChangePassportGateway;

@ShellComponent
@RequiredArgsConstructor
public class ShellController {

    private final ChangePassportGateway changePassportGateway;

    @ShellMethod(value = "start",key = "s")
    public void startApplication() {
        User user = new User("user");
        Passport passport = changePassportGateway.process(user);
        System.out.println("good");

    }

}
