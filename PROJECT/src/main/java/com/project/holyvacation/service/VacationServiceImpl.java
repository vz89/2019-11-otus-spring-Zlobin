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

    public static final String NOTIFICATION_SUBJECT = "Уведомление о скорой поездке";
    public static final String NOTIFICATION_MESSAGE = "Осталось совсем мало дней ";
    private final VacationRepo vacationRepo;
    private final VacationMapper vacationMapper;
    private final MailSender mailSender;

    @Value("${notification.days-left}")
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
    public void VacationDaysLeftNotificationToEmail(List<Vacation> vacations) {
        vacations.forEach(vacation -> {
            mailSender.send(vacation.getUser().getEmail(), NOTIFICATION_SUBJECT, NOTIFICATION_MESSAGE + vacation.getDaysLeft());
        });
    }

    @Override
    public List<Vacation> findAllForNotification() {
        return vacationRepo.findAllByEnableNotificationTrue().stream().filter(vacation -> vacation.getDaysLeft() <= notificationDaysLeft).collect(Collectors.toList());
    }

}
