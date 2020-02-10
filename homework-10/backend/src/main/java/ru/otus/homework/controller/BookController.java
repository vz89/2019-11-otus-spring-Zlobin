package ru.otus.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.dto.BookCommentsDTO;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    private final CommentService commentService;

    public BookController(BookService bookService, CommentService commentService) {
        this.bookService = bookService;
        this.commentService = commentService;
    }


    @GetMapping("/books")
    public ResponseEntity<List<Book>> readAll() {
        List<Book> books = bookService.findAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookCommentsDTO> readBook(@PathVariable("id") long id) {
        try {
            Book book = bookService.findById(id);
            List<Comment> comments = commentService.findAllComments(book);
            BookCommentsDTO bookCommentsDTO = new BookCommentsDTO(book, comments);
            return new ResponseEntity<>(bookCommentsDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
        boolean updated = bookService.update(id, book);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
