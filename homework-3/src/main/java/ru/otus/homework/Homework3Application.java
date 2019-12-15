package ru.otus.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.homework.service.RunnerService;

@SpringBootApplication
public class Homework3Application{
	public static void main(String[] args) {
		SpringApplication.run(Homework3Application.class, args);
	}
}
