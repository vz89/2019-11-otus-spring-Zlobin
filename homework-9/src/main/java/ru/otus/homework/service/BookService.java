package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void addOrSaveBook(Book book);

    void delete(Book book);
}
