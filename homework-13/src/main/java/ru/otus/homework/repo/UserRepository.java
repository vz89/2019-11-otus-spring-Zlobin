package ru.otus.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
