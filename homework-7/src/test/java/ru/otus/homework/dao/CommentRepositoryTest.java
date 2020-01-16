package ru.otus.homework.dao;

import lombok.val;
import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repo.CommentRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с комментариями")
@DataJpaTest
class CommentRepositoryTest {

    private static final String NEW_COMMENT_TEXT = "new comment text";
    private static final long FIRST_BOOK_ID = 1;
    private static final int EXPECTED_NUMBER_OF_COMMENTS = 2;
    private static final long FIRST_COMMENT_ID = 1;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("должен корректно сохранять комментарий в бд")
    @Test
    void shouldSaveComment() {
        Book book = em.find(Book.class, FIRST_BOOK_ID);
        var comment = new Comment(NEW_COMMENT_TEXT, book);
        comment = commentRepository.save(comment);

        assertThat(comment.getId()).isGreaterThan(0);

        val actualComment = em.find(Comment.class, comment.getId());
        assertThat(actualComment).isNotNull().matches(b -> !b.getText().equals(""))
                .matches(b -> b.getBook() != null);
    }

    @DisplayName("должен загружать все комментарии к книге по её Id")
    @Test
    void shouldFindAllCommentsByBookId() {
        val comments = commentRepository.findAllByBook_Id(FIRST_BOOK_ID);
        assertThat(comments).isNotNull().hasSize(EXPECTED_NUMBER_OF_COMMENTS)
                .allMatch(comment -> !comment.getText().equals(""))
                .allMatch(comment -> comment.getBook().getTitle() != null);
    }

    @DisplayName(" должен удалять комментарий по его Id")
    @Test
    void shouldDeleteBookNameById() {
        commentRepository.deleteById(FIRST_COMMENT_ID);
        val deletedComment = em.find(Comment.class, FIRST_COMMENT_ID);
        assertThat(deletedComment).isNull();
    }

    @DisplayName(" должен редактировать комментарий по его Id")
    @Test
    void shouldEditCommentTextById() {
        val firstComment = em.find(Comment.class,FIRST_COMMENT_ID);
        String oldText = firstComment.getText();
        em.clear();

        commentRepository.updateTextById(FIRST_COMMENT_ID,NEW_COMMENT_TEXT);
        val updateComment = em.find(Comment.class,FIRST_COMMENT_ID);

        assertThat(updateComment.getText()).isNotEqualTo(oldText).isEqualTo(NEW_COMMENT_TEXT);
    }


}
