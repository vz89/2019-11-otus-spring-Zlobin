package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment save(Comment comment) {
        return em.merge(comment);
    }

    @Override
    public List<Comment> findByBookId(long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.book.id=:id", Comment.class);
        query.setParameter("id", id);
        return query.getResultList();
    }



    @Override
    public void updateTextById(long id, String text) {

    }

    @Override
    public void deleteById(long id) {
        em.remove(em.find(Comment.class,id));

    }
}
