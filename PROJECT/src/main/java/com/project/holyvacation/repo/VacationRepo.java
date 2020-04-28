package com.project.holyvacation.repo;

import com.project.holyvacation.domain.Vacation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepo extends JpaRepository<Vacation, Long> {

    @EntityGraph(value = "user_country_entity_graph")
    List<Vacation> findAllByUserUsername(String username);

    @EntityGraph(value = "user_country_entity_graph")
    List<Vacation> findAll();

}
