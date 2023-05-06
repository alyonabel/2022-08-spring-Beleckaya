package ru.otus.hw.dao.jdbc;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.hw.dao.BookDao;
import ru.otus.hw.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {
    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = jdbc;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        Integer booksCount = jdbc.queryForObject("select count(*) from books", Integer.class);
        return booksCount==null? 0:booksCount;
    }

    @Override
    public void insert(long id, String name,long authorId,long genreId)  {
        namedParameterJdbcOperations.update("insert into books (id, name, author_id, genre_Id) values (:id,:name,:authorId,:genreId)", Map.of("id",id,"name",name,"authorId",authorId, "genreId",genreId));
    }

    @Override
    public void update(long id,String name,long authorId,long genreId) {
        jdbc.update("update books set `name` = ?,`author_id` = ?, `genre_id` = ? WHERE `id` = ?", name, authorId, genreId, id);
    }

    @Override
    public Book getById (long id) {
        Map<String, Object> params = Collections.singletonMap("id",id);
        return namedParameterJdbcOperations.queryForObject("select b.id, b.name, b.author_id, a.authorName, b.genre_id, g.genreName from (books b inner join genres g on b.genre_id=g.id) inner join authors a on b.author_id = a.id where b.id= :id",params, new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select b.id, b.name,b.author_id, a.authorName,b.genre_id, g.genreName from (books b inner join genres g on b.genre_id=g.id) inner join authors a on b.author_id = a.id", new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id",id);
        namedParameterJdbcOperations.update("delete from books where id= :id", params);
       }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            String author = rs.getString("authorName");
            String genre = rs.getString("genreName");
            return new Book(id,name,author,genre);
        }
    }

}
