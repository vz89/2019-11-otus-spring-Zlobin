package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repo.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    final private CommentRepository commentRepository;
    final private IOService ioService;
    final private BookService bookService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, IOService ioService, BookService bookService) {
        this.commentRepository = commentRepository;
        this.ioService = ioService;
        this.bookService = bookService;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByBookId(long id) {
        return commentRepository.findAllByBook_Id(id);
    }

    @Transactional
    @Override
    public void updateTextById(long id, String text) {
        commentRepository.updateTextById(id, text);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addNewComment() {
        ioService.write("Введите id книги, которой хотите добавить комментарий");
        int bookId = ioService.readInt();
        Book book = bookService.findById(bookId);
        if (book != null) {
            ioService.write("Введите комментарий для книги - " + book.getTitle());
            String commentText = ioService.read();
            Comment comment = new Comment(commentText, book);
            commentRepository.save(comment);
        } else {
            ioService.write("Книги по такому ID не существует.");
        }
    }

    @Override
    public List<Comment> findAllCommentsByAuthorId(long id) {
        return commentRepository.findAllByBookAuthor_Id(id);
    }

}
