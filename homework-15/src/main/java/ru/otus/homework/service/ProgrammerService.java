package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Task;

import java.util.Random;

@Service
public class ProgrammerService {

    public Task findProblem(Task task) throws Exception {
        System.out.println("Ищу проблему №" + task.getName());
        Thread.sleep(2000 + new Random().nextInt(10) * 500);
        System.out.println("Проблему №" + task.getName() + " нашел");
        return task;
    }

    public Task fixProblem(Task task) throws Exception {
        System.out.println("Приступил к решению проблемы №" + task.getName());
        Thread.sleep(2000 + new Random().nextInt(10) * 500);
        System.out.println("Проблему №" + task.getName() + " решил");
        return task;
    }

    public Task testFixedProblem(Task task) throws Exception {
        System.out.println("Тестирую решенную проблему №" + task.getName());
        Thread.sleep(2000 + new Random().nextInt(10) * 500);
        System.out.println("Проблему №" + task.getName() + " оттестирована и работает хорошо");
        return task;
    }

    public Task rest(Task task) throws Exception {
        System.out.println("Пью чай, ем тортики после решения №" + task.getName());
        Thread.sleep(2000 + new Random().nextInt(10) * 500);
        System.out.println("Отдохнул после решения проблемы №" + task.getName() + " и готов вновь работать");
        return task;
    }

}
