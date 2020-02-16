package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repo.BookRepository;

@RestController
@CrossOrigin
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/books")
    public Flux<Book> readAll(){
        return bookRepository.findAll();
    }



}
