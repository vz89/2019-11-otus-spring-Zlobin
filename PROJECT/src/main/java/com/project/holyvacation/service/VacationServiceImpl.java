package com.project.holyvacation.service;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.dto.VacationDTO;
import com.project.holyvacation.dto.mapper.VacationMapper;
import com.project.holyvacation.repo.VacationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {


    private static final int NULL_DAYS = 0;
    private final VacationRepo vacationRepo;
    private final VacationMapper vacationMapper;
    private final MailSender mailSender;

    @Value("${notification.daysLeft}")
    private Long notificationDaysLeft;

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

    @Override
    public VacationDTO findById(Long id) {

        return vacationMapper.toDTO(vacationRepo.findById(id).orElse(null));
    }

    @Override
    public void update(Vacation vacation, VacationDTO vacationDTO) {
        vacationRepo.save(vacationMapper.updateEntity(vacation, vacationDTO));
    }

    @Override
    public void deleteById(Long id) {
        vacationRepo.deleteById(id);
    }


    @Override
    public List<Vacation> findAllForNotification() {
        //return vacationRepo.findAllByEnableNotificationTrue().stream().filter(vacation -> vacation.getDaysLeft() <= notificationDaysLeft && vacation.getDaysLeft() > NULL_DAYS).collect(Collectors.toList());
        return vacationRepo.findAllByEnableNotificationTrue();
    }

}
