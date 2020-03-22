package ru.otus.homework.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.SubscribableChannel;
import ru.otus.homework.domain.Passport;
import ru.otus.homework.domain.User;

import java.util.List;

@IntegrationComponentScan
@EnableIntegration
@Configuration
public class ChannelConfiguration {

    @Bean
    public MessageChannel userChannel() {
        return MessageChannels.direct().datatype(User.class).get();
    }

    @Bean
    public SubscribableChannel passportChannel() {
        return MessageChannels.publishSubscribe().datatype(Passport.class).get();
    }

    @Bean
    public IntegrationFlow flow() {
        return IntegrationFlows.from("userChannel")
                .handle("MigrationDepartmentServiceImpl", "message")
                .channel("passportChannel")
                .get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2).get();
    }




}
