package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Book;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.GenreService;
import ru.otus.homework.service.IOService;

import java.util.List;

@ShellComponent
public class ShellController {
    private final BookService bookService;
    private final IOService ioService;

    @Autowired
    public ShellController(BookService bookService, IOService ioService) {
        this.bookService = bookService;
        this.ioService = ioService;
    }

    @ShellMethod(key = {"book list", "all"}, value = "show all books")
    public void allBooks() {
        List<Book> allBooks = bookService.getAll();
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"add"}, value = "add book to library")
    public void addBook() {
        Book book = bookService.getNewBook();
        bookService.insert(book);
    }

    @ShellMethod(key = {"getById", "gbi"}, value = "get book by Id")
    public void getBookById() {
        long id = ioService.readInt();
        ioService.write(bookService.getById(id).toString());
    }

    @ShellMethod(key = {"deleteById", "dbi"}, value = "delete book by Id")
    public void deleteBookById() {
        long id = ioService.readInt();
        bookService.deleteById(id);
    }

    @ShellMethod(key = "count", value = "count of all books")
    public void bookCount() {
        ioService.write(bookService.getCount());
    }


}
