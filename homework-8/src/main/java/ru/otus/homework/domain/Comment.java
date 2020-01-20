package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Transient
    public static final String SEQUENCE_NAME ="comments_sequence";

    @Id
    private long id;
    private String text;

    public Comment(String text) {
        this.text = text;
    }
}
