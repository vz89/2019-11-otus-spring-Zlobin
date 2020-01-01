package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return Optional.ofNullable(em.find(Genre.class,id));
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public List<Genre> findByName(String name) {
        return null;
    }

    @Override
    public void updateNameById(long id) {

    }

    @Override
    public void deleteById(long id) {

    }
}
