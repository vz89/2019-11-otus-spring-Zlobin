package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genre")
public class Genre {
    @Transient
    public static final String SEQUENCE_NAME = "genres_sequence";
    @Id
    private long id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
