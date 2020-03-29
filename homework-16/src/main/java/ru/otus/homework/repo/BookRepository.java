package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.homework.domain.Book;

import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(value = "author_genre_entity_graph")
    List<Book> findAll();
    void deleteBookById(Long id);

}
