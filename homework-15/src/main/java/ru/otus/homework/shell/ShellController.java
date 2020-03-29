package ru.otus.homework.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;
import ru.otus.homework.integration.PassportForUserGateway;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@ShellComponent
@AllArgsConstructor
public class ShellController {
    private static AtomicInteger num = new AtomicInteger(1);
    private final PassportForUserGateway passportForUserGateway;
    private static String[] FirstNames = {"John","Martin","Greg","Michael","Keith","James"};
    private static String[] LastNames = {"Black","White","Brown","Goodwin","Right","Smith"};

    @ShellMethod("start")
    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(4000);
            Thread thread = new Thread(() -> {
                User user = new User(FirstNames[new Random().nextInt(5)] + " " + LastNames[new Random().nextInt(5)]);
                System.out.println("Появилась новая заявка на замену паспорта №" + num.getAndIncrement() + " " + user.getName());
                Passport passport = passportForUserGateway.process(user);
                System.out.println("Закрыл заявку: " + passport.toString());
            });
            thread.start();
        }
    }
}
