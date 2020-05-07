package com.project.holyvacation.service;

import com.project.holyvacation.domain.EmailMessage;
import com.project.holyvacation.domain.Vacation;

public interface EmailMessageService {
    EmailMessage createNotificationMessageFromVacation(Vacation vacation);
}
