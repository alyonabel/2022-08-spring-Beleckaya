package ru.otus.hw.dao.jdbc;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.hw.dao.GenreDao;
import ru.otus.hw.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = jdbc;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        Integer genresCount = jdbc.queryForObject("select count(*) from genres", Integer.class);
        return genresCount==null? 0:genresCount;
    }

    @Override
    public void insert(Genre genre) {
        namedParameterJdbcOperations.update("insert into genres (id, genreName) values (:id,:genreName)", Map.of("id",genre.getId(),"genreName",genre.getGenreName()));
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id",id);
        return namedParameterJdbcOperations.queryForObject("select id, genreName from genres where id = :id",params, new GenreMapper());
    }

    @Override
    public Genre getByGenre(String genreName) {
        Map<String, Object> params = Collections.singletonMap("genreName",genreName);
        return namedParameterJdbcOperations.queryForObject("select id, genreName from genres where genreName = :genreName",params, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select id, genreName from genres", new GenreMapper());
    }

     private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String genreName = rs.getString("genreName");
            return new Genre(id,genreName);
        }
    }
}
