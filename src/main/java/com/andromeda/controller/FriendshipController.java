package com.andromeda.controller;

import com.andromeda.dto.FriendshipDTO;
import com.andromeda.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friendships")
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping
    public ResponseEntity<FriendshipDTO> createFriendship(@RequestBody FriendshipDTO friendshipDTO) {
        FriendshipDTO createdFriendship = friendshipService.saveFriendship(friendshipDTO);
        return ResponseEntity.ok(createdFriendship);
    }

    @GetMapping
    public ResponseEntity<List<FriendshipDTO>> getAllFriendships() {
        List<FriendshipDTO> friendships = friendshipService.getAllFriendships();
        return ResponseEntity.ok(friendships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FriendshipDTO> getFriendshipById(@PathVariable Long id) {
        FriendshipDTO friendship = friendshipService.getFriendshipById(id);
        return ResponseEntity.ok(friendship);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFriendship(@PathVariable Long id) {
        friendshipService.deleteFriendship(id);
        return ResponseEntity.noContent().build();
    }
}
