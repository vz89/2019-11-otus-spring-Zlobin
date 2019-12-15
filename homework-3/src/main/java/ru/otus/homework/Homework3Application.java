package ru.otus.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.homework.service.RunnerService;

@SpringBootApplication
public class Homework3Application implements CommandLineRunner {
	@Autowired
	RunnerService runnerService;

	public static void main(String[] args) {
		SpringApplication.run(Homework3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		runnerService.run();
	}
}
