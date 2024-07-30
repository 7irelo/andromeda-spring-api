package com.andromeda.repository;

import com.andromeda.entity.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LikeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Like findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM likes WHERE id = ?", new Object[]{id}, this::mapRowToLike);
    }

    public List<Like> findAll() {
        return jdbcTemplate.query("SELECT * FROM likes", this::mapRowToLike);
    }

    public int save(Like like) {
        return jdbcTemplate.update("INSERT INTO likes (user_id, post_id, created_at) VALUES (?, ?, ?)",
                like.getUser().getId(), like.getPost().getId(), like.getCreatedAt());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM likes WHERE id = ?", id);
    }

    private Like mapRowToLike(ResultSet rs, int rowNum) throws SQLException {
        Like like = new Like();
        like.setId(rs.getLong("id"));
        // Assuming User and Post entity have a method findById in respective Repositories
        // like.setUser(userRepository.findById(rs.getLong("user_id")));
        // like.setPost(postRepository.findById(rs.getLong("post_id")));
        like.setCreatedAt(rs.getDate("created_at"));
        return like;
    }
}
