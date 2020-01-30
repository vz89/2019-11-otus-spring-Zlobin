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
@Document(collection = "author")
public class Author {
    @Transient
    public static final String SEQUENCE_NAME = "authors_sequence";
    @Id
    private Long id;
    private String name;


    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Author author = (Author) obj;
        if (this.name != null && author.name != null)
            return (this.id.equals(author.getId()) &&
                    this.name.equals(author.name));
        else return (this.id.equals(author.id) &&
                this.name == author.name);

    }
}
