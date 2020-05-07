package com.project.holyvacation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "vacation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "user_country_city_entity_graph", attributeNodes = {@NamedAttributeNode("user"), @NamedAttributeNode("country"), @NamedAttributeNode("city")})
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date", columnDefinition = "DATE")
    private LocalDate createdDate;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "enable_notification")
    private boolean enableNotification;

    @Transient
    private Long daysLeft;

    public Vacation(String title, String description, LocalDate createdDate, LocalDate startDate, LocalDate endDate, Country country, User user, City city, boolean isPublic, boolean enableNotification) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.user = user;
        this.city = city;
        this.isPublic = isPublic;
        this.enableNotification = enableNotification;
        this.daysLeft = ChronoUnit.DAYS.between(LocalDate.now(),this.startDate);
    }

    public Long getDaysLeft() {
        return this.daysLeft = ChronoUnit.DAYS.between(LocalDate.now(),this.startDate);
    }

}
