package ru.otus.homework.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class Book {
    @Transient
    public static final String SEQUENCE_NAME ="books_sequence";

    @Id
    private long id;
    private String title;
    @DBRef
    private Author author;
    private String genre;
    @DBRef
    private List<Comment> comments;

    public Book(String title, Author author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String toJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author.toString() + '\'' +
                ", genre='" + genre + '\'' +
                ", comments=" + comments +
                '}';
    }

    public String toStringWithCommentCount() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comments=" + ((comments==null) ? "0":comments.size()) +
                '}';
    }
}
