package ru.otus.homework.exception;

import java.io.IOException;

public class QuestionsReadingFailedException extends Exception {
    public QuestionsReadingFailedException(String message) {
        super(message);
    }

    public QuestionsReadingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
