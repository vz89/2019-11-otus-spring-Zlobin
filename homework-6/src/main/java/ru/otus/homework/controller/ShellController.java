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

    @ShellMethod(key = {"list", "all"}, value = "show all books")
    public void allBooks() {
        List<Book> allBooks = bookService.findAll();
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"add"}, value = "add book to library")
    public void addBook() {
       bookService.addNewBook();
    }

    @ShellMethod(key = {"getById", "gbi"}, value = "get book by Id")
    public void getBookById() {
        long id = ioService.readInt();
        ioService.write(bookService.findById(id).toString());
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

    @ShellMethod(key = {"updateNameById","unbi"},value = "update book name by Id")
    public void updateBookNameById(){
        ioService.write("Введите Id книги, которую необходимо изменить");
        long id = ioService.readInt();
        ioService.write("Введите новое название книги");
        String name = ioService.read();
        bookService.updateNameById(id,name);
    }

    @ShellMethod (key ={"findByName","fbn"},value = "find book by name")
    public void findBookByName(){
        ioService.write("Введите имя книги, которую необходимо найти");
        String name = ioService.read();
        List<Book> allBooks = bookService.findByName(name);
        allBooks.forEach(book -> ioService.write(book.toString()));
    }
}
