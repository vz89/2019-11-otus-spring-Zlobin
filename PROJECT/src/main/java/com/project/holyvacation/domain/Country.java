package com.project.holyvacation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iso")
    private String iso;

    @Column(name = "name")
    private String name;

    @Column(name = "nicename")
    private String niceName;

    @Column(name = "iso3")
    private String iso3;

    @Column(name = "numcode")
    private String numCode;

    @Column(name = "phonecode")
    private String phoneCode;
}
