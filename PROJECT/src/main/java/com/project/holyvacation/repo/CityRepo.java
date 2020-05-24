package com.project.holyvacation.repo;

import com.project.holyvacation.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
    City findFirstByCity(String cityName);
}
