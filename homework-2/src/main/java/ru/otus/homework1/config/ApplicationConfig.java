package ru.otus.homework1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public String csvFileName(@Value("${language}") String language){
        return "questions_"+language+".csv";
    }
    @Bean
    public int minRightAnswer(@Value("${test.minrightanswer}") int minRightAnswer){
      return minRightAnswer;
    }
}
