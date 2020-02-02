package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repo.BookRepo;
import ru.otus.homework.repo.CommentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final AuthorService authorService;
    private final CommentRepo commentRepo;
    private final GenreService genreService;


    @Autowired
    public BookServiceImpl(BookRepo bookRepo, SequenceGeneratorService sequenceGeneratorService, AuthorService authorService, CommentRepo commentRepo, GenreService genreService) {
        this.bookRepo = bookRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.authorService = authorService;
        this.commentRepo = commentRepo;
        this.genreService = genreService;
    }

    @Override
    public void addBook(String title, String authorName, String genreName) {
        Author author = authorService.getAuthor(authorName);
        Genre genre = genreService.getGenre(genreName);
        Book book = new Book(title, author, genre);
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
        bookRepo.findById(id).getComments().forEach(commentRepo::delete);
        bookRepo.deleteById(id);
    }

    @Override
    public long getCount() {
        return bookRepo.count();
    }

    @Override
    public void updateNameById(long id, String name) {
        Book book = bookRepo.findById(id);
        book.setTitle(name);
        bookRepo.save(book);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepo.findAllByTitle(name);
    }

    @Override
    public void addComment(long bookId, String commentText) {
        Book book = bookRepo.findById(bookId);
        if (book != null) {
            Comment comment = new Comment(commentText);
            comment.setId(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
            commentRepo.save(comment);
            book.setComments(addCommentToBookCommentList(book, comment));
            bookRepo.save(book);
        }
    }

    @Override
    public List<Comment> findCommentsByBookId(long id) {
        Book book = bookRepo.findById(id);
        return book.getComments();
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        return bookRepo.findAllByAuthorId(id);
    }


    private List<Comment> addCommentToBookCommentList(Book book, Comment comment) {
        if (book.getComments() == null) {
            List<Comment> comments = new ArrayList<>();
            comments.add(comment);
            return comments;
        } else {
            List<Comment> comments = book.getComments();
            comments.add(comment);
            return comments;
        }
    }
}
