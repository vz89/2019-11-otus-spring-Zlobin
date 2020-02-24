package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repo.BookRepository;

@RestController
@CrossOrigin
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/books")
    public Flux<Book> readAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Mono<Book> readBook(@PathVariable("id") String id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Mono<Book> update(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public Mono<Void> deleteBook(@PathVariable("id") String id) {
        return bookRepository.deleteById(id);
    }

}
