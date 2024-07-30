package com.andromeda.repository;

import com.andromeda.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, this::mapRowToUser);
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", this::mapRowToUser);
    }

    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users (username, email, password, created_at) VALUES (?, ?, ?, ?)",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getCreatedAt());
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCreatedAt(rs.getDate("created_at"));
        return user;
    }
}
