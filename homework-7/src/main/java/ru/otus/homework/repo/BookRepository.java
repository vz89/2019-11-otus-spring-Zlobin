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
    List<Book> findAll();

    @EntityGraph(value = "author_genre_entity_graph")
    List<Book> findBooksByTitle(String title);

    @Modifying
    @Query("update Book b set b.title=:name where b.id=:id")
    void updateNameById(@Param("id") Long id,@Param("name") String name);

    void deleteById(long Id);

    @EntityGraph(value = "author_genre_entity_graph")
    List<Book> findBooksByAuthor_Id(long id);

    @Query("select new org.apache.commons.lang3.tuple.ImmutablePair (b, count(c))"+
            "                        from Book b left join Comment c on b.id = c.book.id "+
            "                        group by c.book")

    List<ImmutablePair<Book,Long>> findAllBooksWithCommentsCount();


}
