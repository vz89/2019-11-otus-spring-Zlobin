package com.project.holyvacation.integration;


import com.project.holyvacation.service.EmailMessageService;
import com.project.holyvacation.service.NotificationService;
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

    private static final String CREATE_NOTIFICATION_MESSAGE_FROM_VACATION = "createNotificationMessageFromVacation";
    private static final String SEND_EMAIL_MESSAGE = "sendEmailMessage";

    private final NotificationService notificationService;
    private final EmailMessageService emailMessageService;

    @Bean
    public PollableChannel vacationDaysLeftNotificationInChannel() {
        return MessageChannels.queue("vacationDaysLeftNotificationInChannel", 100).get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(1000).get();
    }

    @Bean
    public IntegrationFlow vacationDaysLeftNotificationFlow() {
        return f -> f.channel(vacationDaysLeftNotificationInChannel())
                .handle(emailMessageService, CREATE_NOTIFICATION_MESSAGE_FROM_VACATION)
                .handle(notificationService, SEND_EMAIL_MESSAGE);
    }
}
