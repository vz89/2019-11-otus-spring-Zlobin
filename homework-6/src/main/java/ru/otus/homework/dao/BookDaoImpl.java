package ru.otus.homework.dao;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Book;


import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book save(Book book) {
        return em.merge(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author_genre_entity_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Book> findByName(String title) {
        EntityGraph<?> entityGraph = em.getEntityGraph("author_genre_entity_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.title=:title", Book.class);
        query.setParameter("title", title);
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        return query.getResultList();
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Book b set b.title=:name where b.id=:id");
        query.setParameter("id", id);
        query.setParameter("name", name);
        query.executeUpdate();
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Book b " +
                "where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public long getCount() {
        return em.createQuery("select count(b) from Book b",Long.class).getSingleResult();
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        EntityGraph<?> entityGraph = em.getEntityGraph("author_genre_entity_graph");
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.author.id=:id",Book.class);
        query.setParameter("id", id);
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Book> findAllWithComments() {
        return null;
    }

    @Override
    public List<ImmutablePair<Book,Long>> findAllBooksWithCommentsCount() {
        Query query = em.createQuery("select new org.apache.commons.lang3.tuple.ImmutablePair (c.book, count(c)) from Comment c group by c.book");
        return query.getResultList();
    }

}
