package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.CommentDao;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    final private CommentDao commentDao;
    final private IOService ioService;
    final private BookService bookService;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, IOService ioService, BookService bookService) {
        this.commentDao = commentDao;
        this.ioService = ioService;
        this.bookService = bookService;
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public List<Comment> findByBookId(long id) {
        return commentDao.findByBookId(id);
    }

    @Override
    public void updateTextById(long id, String text) {
        commentDao.updateTextById(id, text);
    }

    @Override
    public void deleteById(long id) {
        commentDao.deleteById(id);
    }

    @Override
    public void addNewComment() {
        ioService.write("Введите id книги, которой хотите добавить комментарий");
        int bookId = ioService.readInt();
        Book book = bookService.findById(bookId);
        if (book != null) {
            ioService.write("Введите комментарий для книги - " + book.getTitle());
            String commentText = ioService.read();
            Comment comment = new Comment(commentText, book);
            commentDao.save(comment);
        } else {
            ioService.write("Книги по такому ID не существует.");
        }
    }

    @Override
    public List<Comment> findAllCommentsByAuthorId(long id) {
        return commentDao.findAllCommentsByAuthorId(id);
    }

    @Override
    public void deleteByBookId(long id) {
        commentDao.deleteByBookId(id);
    }
}
