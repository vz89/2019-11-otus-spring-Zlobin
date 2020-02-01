package ru.otus.homework.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Author author = (Author) obj;
        if (this.name != null && author.name != null)
            return (this.id.equals(author.id) &&
                    this.name.equals(author.name));
        else return (this.id.equals(author.id) &&
                this.name == author.name);

    }
}
