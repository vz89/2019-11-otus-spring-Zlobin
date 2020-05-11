package com.project.holyvacation.integration;

import com.project.holyvacation.domain.Vacation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface VacationDaysLeftNotificationGateway {

    @Gateway(requestChannel = "vacationDaysLeftNotificationInChannel")
    void process(Vacation vacation);

}
