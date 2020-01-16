package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByBook_Id(long id);

    @Modifying
    @Query("update Comment c set c.text=:text where c.id=:id")
    void updateTextById(@Param("id") Long id,@Param("text") String text);

    List<Comment> findAllByBookAuthor_Id(long id);
}
