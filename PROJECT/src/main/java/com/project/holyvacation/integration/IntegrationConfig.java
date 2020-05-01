package com.project.holyvacation.integration;


import com.project.holyvacation.repo.VacationRepo;
import com.project.holyvacation.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.PollableChannel;

@Configuration
@IntegrationComponentScan
@RequiredArgsConstructor
public class IntegrationConfig {

    private static final String VACATION_DAYS_LEFT_NOTIFICATION_TO_EMAIL = "VacationDaysLeftNotificationToEmail";

    private final VacationService vacationService;

    @Bean
    public PollableChannel VacationDaysLeftNotificationInChannel() {
        return MessageChannels.queue("VacationDaysLeftNotificationInChannel", 100).get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(1000).get();
    }

    @Bean
    public IntegrationFlow VacationDaysLeftNotificationFlow() {
        return f->f.channel(VacationDaysLeftNotificationInChannel())
                .handle(vacationService, VACATION_DAYS_LEFT_NOTIFICATION_TO_EMAIL);
    }
}
