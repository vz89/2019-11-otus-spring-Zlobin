package ru.otus.homework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.ApplicationSettings;

@Service
public class MessageSourceServiceImpl implements MessageSourceService {

    final private MessageSource messageSource;
    final private ApplicationSettings settings;

    public MessageSourceServiceImpl(MessageSource messageSource, ApplicationSettings settings) {

        this.messageSource = messageSource;
        this.settings = settings;
    }

    public String getMessage(String message){
        return messageSource.getMessage(message, null, settings.getLocale());
    }


}
