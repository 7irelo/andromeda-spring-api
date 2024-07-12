package com.example.andromeda.controller;

import com.example.andromeda.model.Media;
import com.example.andromeda.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Media>> getUserMedia(@PathVariable Long userId) {
        return new ResponseEntity<>(mediaService.getUserMedia(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Media> uploadMedia(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.saveMedia(media), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
