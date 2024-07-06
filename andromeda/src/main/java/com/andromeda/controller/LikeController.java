package com.example.andromeda.controller;

import com.example.andromeda.model.Like;
import com.example.andromeda.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Like>> getPostLikes(@PathVariable Long postId) {
        return new ResponseEntity<>(likeService.getPostLikes(postId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Like> likePost(@RequestBody Like like) {
        return new ResponseEntity<>(likeService.saveLike(like), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long id) {
        likeService.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
