package com.project.holyvacation.repo;

import com.project.holyvacation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
