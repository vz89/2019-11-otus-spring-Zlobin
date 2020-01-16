package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByName(String name);
}
