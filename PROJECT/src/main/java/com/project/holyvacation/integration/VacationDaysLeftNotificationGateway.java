package com.project.holyvacation.integration;

import com.project.holyvacation.domain.Vacation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.List;

@MessagingGateway
public interface VacationDaysLeftNotificationGateway {

    @Gateway(requestChannel = "VacationDaysLeftNotificationInChannel")
    void process(List<Vacation> vacations);

}
