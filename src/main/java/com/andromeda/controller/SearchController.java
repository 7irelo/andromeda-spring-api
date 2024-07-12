package com.example.andromeda.controller;

import com.example.andromeda.model.User;
import com.example.andromeda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String query) {
        return new ResponseEntity<>(userService.searchUsers(query), HttpStatus.OK);
    }
}
