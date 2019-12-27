package ru.otus.homework.domain;

public class Book {
    private Long id;
    private String title;
    private Author author;
    private Genre genre;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(String title, Genre genre, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre.getName() +
                '}';
    }
}
