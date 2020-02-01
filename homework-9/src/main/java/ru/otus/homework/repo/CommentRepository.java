package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);

}
