package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Book;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;

import java.util.List;

@RestController("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CommentService commentService;

    @GetMapping()
    public ResponseEntity<List<Book>> readAll() {
        List<Book> books = bookService.findAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> readBook(@PathVariable("id") long id) {
        Book book = bookService.findById(id);
        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Book book) {
        boolean updated = bookService.update(id, book);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Long id) {
        boolean deleted = bookService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

  /*  @GetMapping("/update/{book}")
    public void



    @GetMapping("/view/{book}")
    public String showBook(@PathVariable Book book, Model model) {
        model.addAttribute("book", book);
        List<Comment> comments = commentService.findAllComments(book);
        model.addAttribute("comments", comments);
        return "view";
    }*/
}
