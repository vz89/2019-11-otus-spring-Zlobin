package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Transient
    public static final String SEQUENCE_NAME ="authors_sequence";
    @Id
    private long id;
    private String name;
    @DBRef
    List<Book> books;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String toStringWithBookCount() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "количество книг: " + books.size() +
                "  } ";
    }
}
