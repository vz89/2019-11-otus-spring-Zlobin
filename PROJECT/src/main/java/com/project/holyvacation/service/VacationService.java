package com.project.holyvacation.service;

import com.project.holyvacation.dto.VacationDTO;

import java.util.List;

public interface VacationService {
    List<VacationDTO> getPublicVacations();

    List<VacationDTO> getVacations(String username);

    void save(VacationDTO vacationDTO);
}
