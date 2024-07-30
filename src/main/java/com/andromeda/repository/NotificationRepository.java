package com.andromeda.repository;

import com.andromeda.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NotificationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Notification findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM notifications WHERE id = ?", new Object[]{id}, this::mapRowToNotification);
    }

    public List<Notification> findAll() {
        return jdbcTemplate.query("SELECT * FROM notifications", this::mapRowToNotification);
    }

    public int save(Notification notification) {
        return jdbcTemplate.update("INSERT INTO notifications (recipient_id, message, created) VALUES (?, ?, ?)",
                notification.getRecipient().getId(), notification.getMessage(), notification.getCreated());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM notifications WHERE id = ?", id);
    }

    private Notification mapRowToNotification(ResultSet rs, int rowNum) throws SQLException {
        Notification notification = new Notification();
        notification.setId(rs.getLong("id"));
        notification.setMessage(rs.getString("message"));
        notification.setCreated(rs.getDate("created"));
        // notification.setRecipient(userRepository.findById(rs.getLong("recipient_id")));
        return notification;
    }
}
