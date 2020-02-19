package ru.otus.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String name;


    @Override
    public String toString() {
        return "Author{" +
                ", name='" + name + '\'' +
                '}';
    }


}
