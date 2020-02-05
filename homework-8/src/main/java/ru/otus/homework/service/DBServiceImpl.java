package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

@Service
public class DBServiceImpl implements DBService {

    private final BookDBService bookDBService;
    private final CommentDBService commentDBService;


    public DBServiceImpl(@Qualifier("bookDBService") BookDBService bookDBService,@Qualifier("commentDBService") CommentDBService commentDBService) {
        this.bookDBService = bookDBService;
        this.commentDBService = commentDBService;
    }

    @Override
    public void save(Book book) {
        bookDBService.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDBService.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookDBService.findById(id);
    }

    @Override
    public void delete(Comment comment) {
        commentDBService.delete(comment);
    }

    @Override
    public void deleteById(long id) {
        bookDBService.deleteById(id);
    }

    @Override
    public long count() {
        return bookDBService.count();
    }

    @Override
    public List<Book> findAllByTitle(String name) {
        return bookDBService.findAllByTitle(name);
    }

    @Override
    public void save(Comment comment) {
        commentDBService.save(comment);
    }

    @Override
    public List<Book> findAllByAuthorId(long id) {
        return bookDBService.findAllByAuthorId(id);
    }

}
