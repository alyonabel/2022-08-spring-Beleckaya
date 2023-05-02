package ru.otus.hw.dao.jdbc;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.hw.dao.AuthorDao;
import ru.otus.hw.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = jdbc;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public int count() {
        Integer authorsCount = jdbc.queryForObject("select count(*) from authors", Integer.class);
        return authorsCount==null? 0:authorsCount;
    }

    @Override
    public void insert(Author author) {
      namedParameterJdbcOperations.update("insert into authors (id,authorName) values (:id,:authorName)", Map.of("id",author.getId(),"authorName",author.getAuthorName()));
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id",id);
        return namedParameterJdbcOperations.queryForObject("select id, authorName from authors where id = :id",params, new AuthorMapper());
    }

    @Override
    public Author getByAuthor(String authorName) {
        Map<String, Object> params = Collections.singletonMap("authorName",authorName);
        return namedParameterJdbcOperations.queryForObject("select id, authorName from authors where authorName = :authorName",params, new AuthorMapper());
          }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select id, authorName from authors", new AuthorMapper());
    }

      private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String authorName = rs.getString("authorName");
            return new Author(id,authorName);
        }
    }

}
