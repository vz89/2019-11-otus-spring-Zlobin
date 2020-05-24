package com.project.holyvacation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacationDTO {
    private Long id;

    private String title;

    private String description;

    private LocalDate createdDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private String country;

    private String username;

    private String city;

    private boolean isPublic;

    private boolean enableNotification;

    private Long daysLeft;

}
