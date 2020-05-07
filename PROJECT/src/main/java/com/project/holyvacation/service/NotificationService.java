package com.project.holyvacation.service;

import com.project.holyvacation.domain.EmailMessage;

public interface NotificationService {
    void sendEmailMessage(EmailMessage message);
}
