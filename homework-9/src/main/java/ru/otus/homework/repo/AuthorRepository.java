package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
