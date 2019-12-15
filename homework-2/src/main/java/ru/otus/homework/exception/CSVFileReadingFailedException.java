package ru.otus.homework.exception;

import java.io.IOException;

public class CSVFileReadingFailedException extends Exception {
    public CSVFileReadingFailedException(String message) {
        super(message);
    }

    public CSVFileReadingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
