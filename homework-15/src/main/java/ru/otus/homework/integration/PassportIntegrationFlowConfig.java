package ru.otus.homework.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.homework.service.MigrationDepartmentService;
import ru.otus.homework.service.RegistrationDepartmentService;
import ru.otus.homework.service.RegistryWeddingDepartmentService;

@Configuration
@RequiredArgsConstructor
public class PassportIntegrationFlowConfig {
    private final RegistrationDepartmentService registrationDepartmentService;
    private final RegistryWeddingDepartmentService registryWeddingDepartmentService;
    private final MigrationDepartmentService migrationDepartmentService;

    @Bean
    public QueueChannel userChannel() {
        return MessageChannels.queue(10).get();
    }

    @Bean
    public PublishSubscribeChannel passportChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER )
    public PollerMetadata poller () {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2).get() ;
    }

    @Bean
    public IntegrationFlow workFlow() {
        return IntegrationFlows.from("userChannel")
                .handle(registrationDepartmentService, "addRegistration")
                .handle(registryWeddingDepartmentService,"addWeddingRegistry")
                .handle(migrationDepartmentService,"addMigrationRegistration")
                .channel("passportChannel")
                .get();
    }
}
