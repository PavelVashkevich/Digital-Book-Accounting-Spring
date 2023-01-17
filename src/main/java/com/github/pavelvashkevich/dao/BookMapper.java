package com.github.pavelvashkevich.dao;

import com.github.pavelvashkevich.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setName(rs.getString("name"));
        book.setAuthor(rs.getString("author"));
        book.setYearOfPublish(rs.getInt("year_of_publish"));
        Object personIdObj = rs.getObject(5);
        book.setPersonId(Objects.isNull(personIdObj) ? null : (Integer) personIdObj);
        return book;
    }
}
