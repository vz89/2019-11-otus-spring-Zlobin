package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookDBService bookDBService;
    private final CommentDBService commentDBService;


    @Autowired
    public BookServiceImpl(AuthorService authorService, GenreService genreService, BookDBService bookDBService, CommentDBService commentDBService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookDBService = bookDBService;
        this.commentDBService = commentDBService;
    }

    @Override
    public void addBook(String title, String authorName, String genreName) {
        Author author = authorService.getAuthor(authorName);
        Genre genre = genreService.getGenre(genreName);
        Book book = new Book(title, author, genre);
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
    public void deleteById(long id) {
        bookDBService.findById(id).getComments().forEach(commentDBService::delete);
        bookDBService.deleteById(id);
    }

    @Override
    public long getCount() {
        return bookDBService.count();
    }

    @Override
    public void updateNameById(long id, String name) {
        Book book = bookDBService.findById(id);
        book.setTitle(name);
        bookDBService.save(book);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookDBService.findAllByTitle(name);
    }

    @Override
    public void addComment(long bookId, String commentText) {
        Book book = bookDBService.findById(bookId);
        if (book != null) {
            Comment comment = new Comment(commentText);
            commentDBService.save(comment);
            book.setComments(addCommentToBookCommentList(book, comment));
            bookDBService.save(book);
        }
    }

    @Override
    public List<Comment> findCommentsByBookId(long id) {
        Book book = bookDBService.findById(id);
        return book.getComments();
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        return bookDBService.findAllByAuthorId(id);
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
