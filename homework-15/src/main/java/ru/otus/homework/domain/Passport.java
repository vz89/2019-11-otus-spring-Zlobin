package ru.otus.homework.domain;

import lombok.Data;

@Data
public class Passport {
    String username;
    String registrationId;
    String migrationId;
    String maritalStatus;

    public Passport(String username) {
        this.username = username;
    }
}
