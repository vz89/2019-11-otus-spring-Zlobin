package ru.otus.homework.repo;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(value = "author_genre_entity_graph")
    List<Book> findBooksByTitle(String title);

    @Modifying
    @Query("update Book b set b.title=:name where b.id=:id")
    void updateNameById(@Param("name") String name, @Param("id") Long id);

    void deleteById(long Id);

    //@Query("select count(b) from Book b")
    long countAll();

    @EntityGraph(value = "author_genre_entity_graph")
    List<Book> findBooksByAuthor_Id(long id);

    @Query("select new org.apache.commons.lang3.tuple.ImmutablePair (c.book, count(c)) from Comment c group by c.book")
    public List<ImmutablePair<Book,Long>> findAllBooksWithCommentsCount();


}
