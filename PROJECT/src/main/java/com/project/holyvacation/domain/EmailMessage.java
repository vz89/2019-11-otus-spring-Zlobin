package com.project.holyvacation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailMessage {
    private String email;
    private String subject;
    private String message;
}
