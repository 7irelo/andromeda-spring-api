package com.andromeda.repository;

import com.andromeda.entity.Friendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FriendshipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Friendship findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM friendships WHERE id = ?", new Object[]{id}, this::mapRowToFriendship);
    }

    public List<Friendship> findAll() {
        return jdbcTemplate.query("SELECT * FROM friendships", this::mapRowToFriendship);
    }

    public int save(Friendship friendship) {
        return jdbcTemplate.update("INSERT INTO friendships (from_user_id, to_user_id, created_at) VALUES (?, ?, ?)",
                friendship.getFromUser().getId(), friendship.getToUser().getId(), friendship.getCreatedAt());
    }

    public int update(Friendship friendship) {
        return jdbcTemplate.update("UPDATE friendships SET from_user_id = ?, to_user_id = ?, created_at = ? WHERE id = ?",
                friendship.getFromUser().getId(), friendship.getToUser().getId(), friendship.getCreatedAt(), friendship.getId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM friendships WHERE id = ?", id);
    }

    private Friendship mapRowToFriendship(ResultSet rs, int rowNum) throws SQLException {
        Friendship friendship = new Friendship();
        friendship.setId(rs.getLong("id"));
        // Assuming User entity has a method findById in UserRepository
        // friendship.setFromUser(userRepository.findById(rs.getLong("from_user_id")));
        // friendship.setToUser(userRepository.findById(rs.getLong("to_user_id")));
        friendship.setCreatedAt(rs.getDate("created_at"));
        return friendship;
    }
}
