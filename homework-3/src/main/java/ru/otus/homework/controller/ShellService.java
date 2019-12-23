package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework.service.RunnerService;

@ShellComponent
public class ShellService {
    private final RunnerService runnerService;

   @Autowired
    public ShellService(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @ShellMethod(key = "start",value ="start app")
    public void startApp(){
        runnerService.run();
    }


}
