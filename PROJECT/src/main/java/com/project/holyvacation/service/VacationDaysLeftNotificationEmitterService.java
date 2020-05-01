package com.project.holyvacation.service;

import com.project.holyvacation.domain.Vacation;
import com.project.holyvacation.integration.VacationDaysLeftNotificationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationDaysLeftNotificationEmitterService {
    private final VacationDaysLeftNotificationGateway vacationDaysLeftNotificationGateway;
    private final VacationService vacationService;

    @Scheduled(initialDelay = 1000, fixedDelay = 86400000)
    public void emitVacationDaysLeftNotification(){
        List<Vacation> vacations = vacationService.findAllForNotification();
        vacationDaysLeftNotificationGateway.process(vacations);
    }
}
