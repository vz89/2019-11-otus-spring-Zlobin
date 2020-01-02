package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;
import ru.otus.homework.service.IOService;

import java.util.List;

@ShellComponent
public class ShellController {
    private final BookService bookService;
    private final IOService ioService;
    private final CommentService commentService;

    @Autowired
    public ShellController(BookService bookService, IOService ioService, CommentService commentService) {
        this.bookService = bookService;
        this.ioService = ioService;
        this.commentService = commentService;
    }

    @ShellMethod(key = {"bookList","bl"}, value = "show all books")
    public void allBooks() {
        List<Book> allBooks = bookService.findAll();
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"bookAdd","ba"}, value = "add book to library")
    public void addBook() {
        bookService.addNewBook();
    }

    @ShellMethod(key = {"bookGetById", "bgbi"}, value = "get book by Id")
    public void getBookById() {
        long id = ioService.readInt();
        ioService.write(bookService.findById(id).toString());
    }

    @ShellMethod(key = {"bookDeleteById", "bdbi"}, value = "delete book by Id")
    public void deleteBookById() {
        long id = ioService.readInt();
        bookService.deleteById(id);
    }

    @ShellMethod(key = {"booksCount","bc"}, value = "count of all books")
    public void bookCount() {
        ioService.write(bookService.getCount());
    }

    @ShellMethod(key = {"bookUpdateNameById", "bunbid"}, value = "update book name by Id")
    public void updateBookNameById() {
        ioService.write("Введите Id книги, которую необходимо изменить");
        long id = ioService.readInt();
        ioService.write("Введите новое название книги");
        String name = ioService.read();
        bookService.updateNameById(id, name);
    }

    @ShellMethod(key = {"bookFindByName", "bfbn"}, value = "find book by name")
    public void findBookByName() {
        ioService.write("Введите имя книги, которую необходимо найти");
        String name = ioService.read();
        List<Book> allBooks = bookService.findByName(name);
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"commentAdd", "ca"}, value = "add comment to book by Id")
    public void addCommentToBookById() {
        commentService.addNewComment();
    }
    @ShellMethod(key={"commentShowAll","csha"},value = "show all comments to book by Id")
    public void showAllCommentsToBookById(){
        ioService.write("Введите Id книги, по которой отобразить комментарии");
        long id = ioService.readInt();
        List<Comment> allComments = commentService.findByBookId(id);
        ioService.write("Комментарии к книге " + bookService.findById(id).getTitle());
        allComments.forEach(comment -> ioService.write(comment.toString()));
    }
    @ShellMethod(key = {"commentDeleteById","cdbid"},value = "delete comment by Id")
    public void deleteCommentById(){
        ioService.write("Введите Id комментария, который надо удалить");
        long id = ioService.readInt();
        commentService.deleteById(id);
    }

}
