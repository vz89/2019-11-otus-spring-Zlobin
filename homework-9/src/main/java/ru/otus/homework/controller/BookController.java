package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CommentService commentService;

    @GetMapping("/")
    public String books(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book(new Author(), new Genre()));
        return "edit";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        bookService.addOrSaveBook(book);
        return "redirect:/";
    }

    @PostMapping("/delete/{book}")
    public String deleteBook(@PathVariable Book book) {
        bookService.delete(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{book}")
    public String editBook(@PathVariable Book book, Model model) {
        model.addAttribute("book", book);
        return "edit";
    }

    @GetMapping("/view/{book}")
    public String showBook(@PathVariable Book book, Model model) {
        model.addAttribute("book", book);
        List<Comment> comments = commentService.findAllComments(book);
        model.addAttribute("comments", comments);
        return "view";
    }
}
