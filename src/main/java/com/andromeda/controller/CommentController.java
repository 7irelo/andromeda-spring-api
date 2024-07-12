package com.example.andromeda.controller;

import com.example.andromeda.model.Comment;
import com.example.andromeda.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getPostComments(@PathVariable Long postId) {
        return new ResponseEntity<>(commentService.getPostComments(postId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> commentPost(@RequestBody Comment comment) {
        comment.setCreatedAt(new Date());
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
