package com.andromeda.repository;

import com.andromeda.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Post findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM posts WHERE id = ?", new Object[]{id}, this::mapRowToPost);
    }

    public List<Post> findAll() {
        return jdbcTemplate.query("SELECT * FROM posts", this::mapRowToPost);
    }

    public int save(Post post) {
        return jdbcTemplate.update("INSERT INTO posts (creator_id, content, created, updated) VALUES (?, ?, ?, ?)",
                post.getCreator().getId(), post.getContent(), post.getCreated(), post.getUpdated());
    }

    public int update(Post post) {
        return jdbcTemplate.update("UPDATE posts SET content = ?, updated = ? WHERE id = ?",
                post.getContent(), post.getUpdated(), post.getId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM posts WHERE id = ?", id);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setContent(rs.getString("content"));
        post.setCreated(rs.getDate("created"));
        post.setUpdated(rs.getDate("updated"));
        // post.setCreator(userRepository.findById(rs.getLong("creator_id")));
        return post;
    }
}
