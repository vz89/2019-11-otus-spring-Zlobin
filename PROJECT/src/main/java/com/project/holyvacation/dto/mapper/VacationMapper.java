package com.project.holyvacation.dto.mapper;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;

public interface VacationMapper {
    VacationDTO toDTO(Vacation vacation);
    Vacation toEntity(VacationDTO vacationDTO);

    Vacation updateEntity(Vacation vacation, VacationDTO vacationDTO);
}
