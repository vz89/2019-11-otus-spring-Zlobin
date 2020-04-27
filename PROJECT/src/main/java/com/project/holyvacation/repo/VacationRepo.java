package com.project.holyvacation.repo;

import com.project.holyvacation.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepo extends JpaRepository<Vacation, Long> {
}
