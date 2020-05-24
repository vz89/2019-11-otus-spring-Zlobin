package com.project.holyvacation.service;

import com.project.holyvacation.domain.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final MailSender mailSender;

    public void sendEmailMessage(EmailMessage emailMessage) {
        mailSender.send(emailMessage.getEmail(),emailMessage.getSubject(),emailMessage.getMessage());
    }
}
