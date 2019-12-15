package ru.otus.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ApplicationConfig {

    private final String csvFileName;
    private final int minRightAnswer;
    private final Locale locale;


    public ApplicationConfig(@Value("${test.minrightanswer}") int minRightAnswer,
                             @Value("${language}") String language) {
        this.csvFileName = language;
        this.minRightAnswer = minRightAnswer;
        this.locale = new Locale(language);
    }

    public String getCsvFileName() {
        return "questions_" + csvFileName + ".csv";
    }

    public int getMinRightAnswer() {
        return minRightAnswer;
    }

    public Locale getLocale() {
        return locale;
    }
}
