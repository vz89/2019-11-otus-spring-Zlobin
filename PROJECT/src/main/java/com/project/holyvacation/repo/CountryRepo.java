package com.project.holyvacation.repo;

import com.project.holyvacation.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByNiceName(String name);
}
