package ru.otus.homework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@ConfigurationProperties("application")
public class ApplicationSettings {
    private int minRightAnswer;
    private String language;

    public int getMinRightAnswer() {
        return minRightAnswer;
    }

    public void setMinRightAnswer(int minRightAnswer) {
        this.minRightAnswer = minRightAnswer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Locale getLocale() {
        return new Locale(language);
    }
    public String getCsvFileName() {
        return "questions_" + getLanguage() + ".csv";
    }

}
