package ru.otus.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.dto.AuthorBookCountAggregateResult;
import ru.otus.homework.service.AuthorService;
import ru.otus.homework.service.BookService;
import ru.otus.homework.service.CommentService;
import ru.otus.homework.service.IOService;

import java.util.List;

@ShellComponent
public class ShellController {
    private final BookService bookService;
    private final IOService ioService;
    private final CommentService commentService;
    private final AuthorService authorService;

    @Autowired
    public ShellController(BookService bookService, IOService ioService, CommentService commentService, AuthorService authorService) {
        this.bookService = bookService;
        this.ioService = ioService;
        this.commentService = commentService;
        this.authorService = authorService;
    }

    @ShellMethod(key = {"bookList", "bl"}, value = "show all books")
    public void allBooks() {
        List<Book> allBooks = bookService.findAll();
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"bookAdd", "ba"}, value = "add book to library")
    public void addBook() {
        ioService.write("Введите наименование книги");
        String title = ioService.read();
        ioService.write("Введите жанр");
        String genreName = ioService.read();
        ioService.write("Введите автора");
        String authorName = ioService.read();
        bookService.addBook(title, authorName, genreName);
    }

    @ShellMethod(key = {"bookGetById", "bgbi"}, value = "get book by Id")
    public void getBookById() {
        long id = ioService.readInt();
        ioService.write(bookService.findById(id).toString());
    }

    @ShellMethod(key = {"bookDeleteById", "bdbi"}, value = "delete book by Id")
    public void deleteBookById() {
        long id = ioService.readInt();
        bookService.deleteById(id);
    }

    @ShellMethod(key = {"booksCount", "bc"}, value = "count of all books")
    public void bookCount() {
        ioService.write(bookService.getCount());
    }

    @ShellMethod(key = {"bookUpdateNameById", "bunbid"}, value = "update book name by Id")
    public void updateBookNameById() {
        ioService.write("Введите Id книги, которую необходимо изменить");
        long id = ioService.readInt();
        ioService.write("Введите новое название книги");
        String name = ioService.read();
        bookService.updateNameById(id, name);
    }

    @ShellMethod(key = {"bookFindByName", "bfbn"}, value = "find book by name")
    public void findBookByName() {
        ioService.write("Введите имя книги, которую необходимо найти");
        String name = ioService.read();
        List<Book> allBooks = bookService.findByName(name);
        allBooks.forEach(book -> ioService.write(book.toString()));
    }

    @ShellMethod(key = {"commentAdd", "ca"}, value = "add comment to book by Id")
    public void addCommentToBookById() {
        ioService.write("Введите id книги, которой хотите добавить комментарий");
        int bookId = ioService.readInt();
        Book book = bookService.findById(bookId);
        if (book != null) {
            ioService.write("Введите комментарий для книги - " + book.getTitle());
            String commentText = ioService.read();
            bookService.addComment(bookId, commentText);
        } else {
            ioService.write("Книги по такому ID не существует.");
        }
    }

    @ShellMethod(key = {"commentShowAll", "csha"}, value = "show all comments to book by Id")
    public void showAllCommentsToBookById() {
        ioService.write("Введите Id книги, по которой отобразить комментарии");
        long id = ioService.readInt();
        List<Comment> allComments = bookService.findCommentsByBookId(id);
        ioService.write("Комментарии к книге " + bookService.findById(id).getTitle());
        if (allComments != null) {
            allComments.forEach(comment -> ioService.write(comment.toString()));
        } else ioService.write("У книги отсутствуют комментарии");
    }

    @ShellMethod(key = {"commentDeleteById", "cdbid"}, value = "delete comment by Id")
    public void deleteCommentById() {
        ioService.write("Введите Id комментария, который надо удалить");
        long id = ioService.readInt();
        commentService.deleteById(id);
    }

    @ShellMethod(key = {"authorListAlternativeMethod", "alam"}, value = "show all authors and count of books alternative method")
    public void showAllAuthorsAlternative() {
        List<AuthorBookCountAggregateResult> list = authorService.findAllAuthorsWithBooksCount();
        list.forEach(author -> ioService.write(author.toString()));
    }


    @ShellMethod(key = {"bookListByAuthorId", "blai"}, value = "show all books by author id")
    public void showAllBooksByAuthorId() {
        ioService.write("Введите Id автора для отображения списка его книг");
        long id = ioService.readInt();
        List<Book> books = bookService.findAllBooksByAuthorId(id);
        ioService.write("Книги автора: " + authorService.findById(id).getName());
        books.forEach(book -> ioService.write(book.getTitle()));
    }

    @ShellMethod(key = {"commentListByAuthorId", "clbai"}, value = "show all comments to all books by author id")
    public void showAllCommentsByAuthorId() {
        ioService.write("Введите Id автора для отображения всех комментариев к его книгам");
        long id = ioService.readInt();
        List<Book> books = bookService.findAllBooksByAuthorId(id);
        ioService.write("Комментарии к книгам автора: " + authorService.findById(id).getName());
        books.forEach(book -> {
            if (book.getComments() != null)
                ioService.write("Книга: " + book.getTitle() + ". Комментарии: " + book.getComments().toString());
            else ioService.write("Книга: " + book.getTitle() + ". Комментарии: 0");
        });
    }

    @ShellMethod(key = {"bookListWithCommentsCountGroupBy", "blwc"}, value = "show all books and comments counts")
    public void showAllBooksWithComments() {
        List<Book> books = bookService.findAll();
        books.forEach(author ->
        {
            ioService.write(author.toStringWithCommentCount());
        });
    }
}
