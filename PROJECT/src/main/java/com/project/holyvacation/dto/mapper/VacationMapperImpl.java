package com.project.holyvacation.dto.mapper;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.repo.CityRepo;
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
    private final CityRepo cityRepo;


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
                vacation.getCity().getCity(),
                vacation.isPublic(),
                vacation.isEnableNotification(),
                vacation.getDaysLeft()
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
                countryRepo.findByNiceName(vacationDTO.getCountry()),
                userRepo.findByUsername(vacationDTO.getUsername()),
                cityRepo.findFirstByCity(vacationDTO.getCity()),
                vacationDTO.isPublic(),
                vacationDTO.isEnableNotification()
        );
    }

    @Override
    public Vacation updateEntity(Vacation vacation, VacationDTO vacationDTO) {
        vacation.setTitle(vacationDTO.getTitle());
        vacation.setDescription(vacationDTO.getDescription());
        vacation.setStartDate(vacationDTO.getStartDate());
        vacation.setEndDate(vacationDTO.getEndDate());
        vacation.setCountry(countryRepo.findByNiceName(vacationDTO.getCountry()));
        vacation.setCity(cityRepo.findFirstByCity(vacationDTO.getCity()));
        return vacation;
    }
}
