package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.service.RunnerService;

@ShellComponent
public class ShellController {
    private final RunnerService runnerService;

   @Autowired
    public ShellController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @ShellMethod(key = "start",value ="start app")
    public void startApp(){
        runnerService.run();
    }


}
