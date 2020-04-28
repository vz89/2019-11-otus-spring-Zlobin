package com.project.holyvacation.dto.mapper;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.repo.CountryRepo;
import com.project.holyvacation.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VacationMapperImpl implements VacationMapper {
    private final UserRepo userRepo;
    private final CountryRepo countryRepo;


    @Override
    public VacationDTO toDTO(Vacation vacation) {
        return new VacationDTO(
                vacation.getId(),
                vacation.getTitle(),
                vacation.getDescription(),
                vacation.getCreatedDate(),
                vacation.getStartDate(),
                vacation.getEndDate(),
                vacation.getCountry().getNiceName(),
                vacation.getUser().getUsername(),
                vacation.isPublic()
        );
    }

    @Override
    public Vacation toEntity(VacationDTO vacationDTO) {
        return new Vacation(
                vacationDTO.getTitle(),
                vacationDTO.getDescription(),
                LocalDate.now(),
                vacationDTO.getStartDate(),
                vacationDTO.getEndDate(),
                countryRepo.getByNiceName(vacationDTO.getCountry()),
                userRepo.getByUsername(vacationDTO.getUsername()),
                vacationDTO.isPublic()
                );
    }
}
