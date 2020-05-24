package com.project.holyvacation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HolyVacationApplication {
    public static void main(String[] args) {
        SpringApplication.run(HolyVacationApplication.class, args);
    }
}
