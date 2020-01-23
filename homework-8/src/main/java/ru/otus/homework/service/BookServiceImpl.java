package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.AuthorBookCount;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repo.AuthorRepo;
import ru.otus.homework.repo.BookRepo;
import ru.otus.homework.repo.CommentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final IOService ioService;
    private final BookRepo bookRepo;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final AuthorRepo authorRepo;
    private final AuthorService authorService;
    private final CommentRepo commentRepo;


    @Autowired
    public BookServiceImpl(IOService ioService, BookRepo bookRepo, SequenceGeneratorService sequenceGeneratorService, AuthorRepo authorRepo, AuthorService authorService, CommentRepo commentRepo) {
        this.ioService = ioService;
        this.bookRepo = bookRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.authorRepo = authorRepo;
        this.authorService = authorService;
        this.commentRepo = commentRepo;
    }

    @Override
    public void addBook() {
        ioService.write("Введите наименование книги");
        String title = ioService.read();
        ioService.write("Введите жанр");
        String genreName = ioService.read();
        ioService.write("Введите автора");
        String authorName = ioService.read();

        Author author = authorService.getAuthor(authorName);



        Book book = new Book(title, author, genreName);
        book.setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
        bookRepo.save(book);
        author.setBooks(authorService.addBookToAuthorsBookList(author,book));
        authorRepo.save(author);

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
    public void addComment() {
        ioService.write("Введите id книги, которой хотите добавить комментарий");
        int bookId = ioService.readInt();
        Book book = bookRepo.findById(bookId);
        if (book != null) {
            ioService.write("Введите комментарий для книги - " + book.getTitle());
            String commentText = ioService.read();
            Comment comment = new Comment(commentText);
            comment.setId(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
            commentRepo.save(comment);
            book.setComments(addCommentToBookCommentList(book,comment));
            bookRepo.save(book);
        } else {
            ioService.write("Книги по такому ID не существует.");
        }
    }

    @Override
    public List<Comment> findCommentsByBookId(long id) {
        Book book = bookRepo.findById(id);
        return book.getComments();
    }

    @Override
    public List<AuthorBookCount> findAllAuthorsWithBooksCount() {
        return bookRepo.findAllAuthorsWithBooksCount();
    }

    private List<Comment> addCommentToBookCommentList(Book book, Comment comment) {
        if (book.getComments() == null) {
            List<Comment> comments = new ArrayList<>();
            comments.add(comment);
            return comments;
        }
        else {
            List<Comment> comments = book.getComments();
            comments.add(comment);
            return comments;
        }
    }
}
