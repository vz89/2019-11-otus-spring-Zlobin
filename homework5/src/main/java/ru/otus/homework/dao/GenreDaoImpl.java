package ru.otus.homework.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    public GenreDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void insert(Genre genre) {

    }

    @Override
    public Genre getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);

        return jdbcOperations.queryForObject("select * from genre where id = :id",
                params, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}
