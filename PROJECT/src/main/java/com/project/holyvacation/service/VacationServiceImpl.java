package com.project.holyvacation.service;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.dto.mapper.VacationMapper;
import com.project.holyvacation.repo.VacationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {
    private final VacationRepo vacationRepo;
    private final VacationMapper vacationMapper;

    @Override
    public List<VacationDTO> getPublicVacations() {
        return vacationRepo.findAll().stream().filter(Vacation::isPublic).map(vacationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<VacationDTO> getVacations(String username) {
        return vacationRepo.findAllByUserUsername(username).stream().map(vacationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void save(VacationDTO vacationDTO) {
        vacationRepo.save(vacationMapper.toEntity(vacationDTO));
    }


}
