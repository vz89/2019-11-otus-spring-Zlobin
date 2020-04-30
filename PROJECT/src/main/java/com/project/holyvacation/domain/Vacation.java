package com.project.holyvacation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
@Data
@NoArgsConstructor
@NamedEntityGraph(name = "user_country_entity_graph", attributeNodes = {@NamedAttributeNode("user"), @NamedAttributeNode("country")})
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
    }
}
