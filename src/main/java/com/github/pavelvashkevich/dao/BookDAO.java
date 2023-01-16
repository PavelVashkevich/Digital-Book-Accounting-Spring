package com.github.pavelvashkevich.dao;

import com.github.pavelvashkevich.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, year_of_publish) VALUES (?, ?, ?)",
                book.getName(), book.getAuthor(), book.getYearOfPublish());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{id}, new BookMapper())
                .stream().findFirst().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year_of_publish=? WHERE book_id=?",
                book.getName(), book.getAuthor(), book.getYearOfPublish(), id);
    }

    public List<Book> showPersonBooks(int personId) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{personId}, new BookMapper());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", id);
    }
}