package com.project.holyvacation.repo;

import com.project.holyvacation.domain.Vacation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacationRepo extends JpaRepository<Vacation, Long> {

    @EntityGraph(value = "user_country_city_entity_graph")
    List<Vacation> findAllByUserUsername(String username);

    @EntityGraph(value = "user_country_city_entity_graph")
    List<Vacation> findAll();

    @Query(value = "SELECT * FROM holyvacation.vacation where enable_notification=1 AND datediff(start_date,now())<=5",
            nativeQuery = true)
    List<Vacation> findAllByEnableNotificationTrue();
}
