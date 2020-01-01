package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.ofNullable(em.find(Author.class,id));
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> findByName(String name) {
        return null;
    }

    @Override
    public void updateNameById(long id) {

    }

    @Override
    public void deleteById(long id) {

    }
}
