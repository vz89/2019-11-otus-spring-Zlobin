package ru.otus.homework.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="author")
@NamedEntityGraph(name = "book_entity_graph",attributeNodes = {@NamedAttributeNode("books")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book> books;


    public Author (Long id,String name){
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return id + " " + name + ". Количество книг: " + books.size();
    }
}
