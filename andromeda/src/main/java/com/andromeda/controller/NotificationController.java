package com.example.andromeda.controller;

import com.example.andromeda.model.Notification;
import com.example.andromeda.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
        return new ResponseEntity<>(notificationService.getUserNotifications(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        notification.setCreatedAt(new Date());
        return new ResponseEntity<>(notificationService.saveNotification(notification), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
