package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repo.AuthorRepo;
import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final SequenceGeneratorService sequenceGeneratorService;

    public AuthorServiceImpl(AuthorRepo authorRepo, SequenceGeneratorService sequenceGeneratorService) {
        this.authorRepo = authorRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Author getAuthor(String authorName) {
        Author author = authorRepo.findByName(authorName);
        if (author == null) {
            return authorRepo.save(new Author(sequenceGeneratorService.generateSequence(Author.SEQUENCE_NAME), authorName));
        } else return author;
    }

    @Override
    public List<Book> addBookToAuthorsBookList(Author author, Book book) {
        if (author.getBooks() == null) {
            List<Book> books = new ArrayList<>();
            books.add(book);
            return books;
        } else {
            List<Book> books = author.getBooks();
            books.add(book);
            return books;
        }
    }

    @Override
    public List<Author> findAllWithBooksCount() {
        return authorRepo.findAll();
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        return authorRepo.findById(id).get().getBooks();
    }

    @Override
    public Author findById(long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount() {
        return authorRepo.findAllAuthorsWithBooksCount();
    }
}
