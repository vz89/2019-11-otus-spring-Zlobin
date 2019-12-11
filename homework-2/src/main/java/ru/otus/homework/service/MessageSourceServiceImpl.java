package ru.otus.homework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.ApplicationConfig;

@Service
public class MessageSourceServiceImpl implements MessageSourceService {
    private final ApplicationConfig applicationConfig;
    final private MessageSource messageSource;

    public MessageSourceServiceImpl(ApplicationConfig applicationConfig, MessageSource messageSource) {
        this.applicationConfig = applicationConfig;
        this.messageSource = messageSource;
    }

    public String getMessage(String message){
        return messageSource.getMessage(message, null, applicationConfig.getLocale());
    }


}
