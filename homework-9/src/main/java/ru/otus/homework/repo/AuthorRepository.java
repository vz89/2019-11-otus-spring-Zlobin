package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @EntityGraph(value = "book_entity_graph")
    List<Author> findAll();

    Optional<Author> findByName(String name);
}
