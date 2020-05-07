package com.project.holyvacation.service;

import com.project.holyvacation.domain.EmailMessage;
import com.project.holyvacation.domain.Vacation;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageServiceImpl implements EmailMessageService {

    private static final String NOTIFICATION_SUBJECT = "Уведомление о скорой поездке";
    private static final String NOTIFICATION_MESSAGE = "Осталось совсем мало дней ";

    @Override
    public EmailMessage createNotificationMessageFromVacation(Vacation vacation) {
        return new EmailMessage(vacation.getUser().getEmail(), NOTIFICATION_SUBJECT, NOTIFICATION_MESSAGE + vacation.getDaysLeft());
    }
}
