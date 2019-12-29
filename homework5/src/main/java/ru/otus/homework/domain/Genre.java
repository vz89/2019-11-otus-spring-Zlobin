package ru.otus.homework.domain;

public class Genre {
    private Long id;
    private String name;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre(Long id) {
        this.id = id;
    }

    public Genre(String genreName) {
        this.name = genreName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Genre genre = (Genre) obj;
        if (this.name != null && genre.name != null)
            return (this.id.equals(genre.id) &&
                    this.name.equals(genre.name));
        else return (this.id.equals(genre.id) &&
                this.name == genre.name);
    }
}
