package ru.otus.homework.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {
    private final NamedParameterJdbcOperations jdbcOperations;

    public BookDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public int getCount() {
        return jdbcOperations.queryForObject("select count(*) from book",new HashMap<>(1),Integer.class);
    }

    @Override
    public void insert(Book book) {
        final Map<String, Object> params = new HashMap<>(2);
        params.put("id", book.getId());
        params.put("title",book.getTitle());
        jdbcOperations.update("insert into book(id,title) values(:id,:title)",params);
    }

    @Override
    public Book getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);

        return jdbcOperations.queryForObject("select * from book where id = :id",
                params, new BookMapper());
    }
    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select * from book", new BookMapper());
    }

    public void deleteById(long id){
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        jdbcOperations.update("delete from book where id=:id",params);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            return new Book(id, title);
        }
    }


}
