package com.project.holyvacation.service;

public interface MailSender {
    void send(String emailTo, String subject, String message);
}
