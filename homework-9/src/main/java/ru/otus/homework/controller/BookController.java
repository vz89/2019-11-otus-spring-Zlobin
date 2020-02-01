package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String books(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        String title ="";
        String authorName = "";
        String genreName ="";
        model.addAttribute("title",title);
        model.addAttribute("authorName",authorName);
        model.addAttribute("genreName",genreName);
        return "edit";
    }

    @PostMapping("/addbook")
    public String addBook(@RequestParam String authorName,
                          @RequestParam String genreName,
                          @RequestParam String title) {
        bookService.addBook(title,authorName,genreName);
        return "redirect:/";
    }

}
