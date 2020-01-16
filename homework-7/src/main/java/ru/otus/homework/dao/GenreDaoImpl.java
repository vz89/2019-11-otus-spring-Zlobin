package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre save(Genre genre) {
        if (genre.getId() == null) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public Genre findByName(String name) {
        try {
            TypedQuery<Genre> query = em.createQuery("select g from Genre g where g.name=:name", Genre.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
