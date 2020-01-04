package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    public List<Comment> findByBookId(long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.book.id=:id", Comment.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void updateTextById(long id, String text) {
        Query query = em.createQuery("update Comment c set c.text=:text where c.id=:id");
        query.setParameter("id", id);
        query.setParameter("text", text);
        query.executeUpdate();
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Comment c " +
                "where c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Comment> findAllCommentsByAuthorId(long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c left join c.book b where b.author.id=:id",Comment.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void deleteByBookId(long id) {
        Query query = em.createQuery("delete " +
                "from Comment c " +
                "where c.book.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
