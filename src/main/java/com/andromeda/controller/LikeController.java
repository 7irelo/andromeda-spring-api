package com.andromeda.controller;

import com.andromeda.dto.LikeDTO;
import com.andromeda.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<LikeDTO> createLike(@RequestBody LikeDTO likeDTO) {
        LikeDTO createdLike = likeService.saveLike(likeDTO);
        return ResponseEntity.ok(createdLike);
    }

    @GetMapping
    public ResponseEntity<List<LikeDTO>> getAllLikes() {
        List<LikeDTO> likes = likeService.getAllLikes();
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> getLikeById(@PathVariable Long id) {
        LikeDTO like = likeService.getLikeById(id);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return ResponseEntity.noContent().build();
    }
}
