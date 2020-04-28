package com.project.holyvacation.repo;

import com.project.holyvacation.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepo extends JpaRepository<Vacation, Long> {
    List<Vacation> findAllByUserUsername(String username);
}
