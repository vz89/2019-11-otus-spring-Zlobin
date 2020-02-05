package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repo.BookRepo;

import java.util.List;

@Service
@Qualifier("bookDBService")
public class BookDBServiceImpl implements BookDBService {
    private final SequenceGeneratorService sequenceGeneratorService;
    private final BookRepo bookRepo;

    public BookDBServiceImpl(SequenceGeneratorService sequenceGeneratorService, BookRepo bookRepo) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.bookRepo = bookRepo;
    }

    @Override
    public void save(Book book) {
        book.setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
        bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public long count() {
        return bookRepo.count();
    }

    @Override
    public List<Book> findAllByTitle(String name) {
        return bookRepo.findAllByTitle(name);
    }

    @Override
    public List<Book> findAllByAuthorId(long id) {
        return bookRepo.findAllByAuthorId(id);
    }
}
