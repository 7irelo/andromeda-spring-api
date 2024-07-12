package com.example.andromeda.controller;

import com.example.andromeda.model.Post;
import com.example.andromeda.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.getUserPosts(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setCreatedAt(new Date());
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
