package ru.otus.homework.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Task;
import ru.otus.homework.integration.Work;

import java.util.concurrent.atomic.AtomicInteger;

@ShellComponent
@AllArgsConstructor
public class ShellController {
    private static AtomicInteger num = new AtomicInteger(1);
    private final Work work;

    @ShellMethod("start")
    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Task task = new Task(String.valueOf(num.getAndIncrement()));
                    System.out.println("Появилась новая проблема №" + task.getName());
                    Task bugfixed = work.process(task);
                    System.out.println("Закрыл сообщение о проблеме №" + bugfixed.getName());

                }
            });

            thread.start();
        }
    }
}
