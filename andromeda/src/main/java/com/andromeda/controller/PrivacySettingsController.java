package com.example.andromeda.controller;

import com.example.andromeda.model.PrivacySettings;
import com.example.andromeda.service.PrivacySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/privacy-settings")
public class PrivacySettingsController {

    @Autowired
    private PrivacySettingsService privacySettingsService;

    @GetMapping("/{userId}")
    public ResponseEntity<PrivacySettings> getPrivacySettings(@PathVariable Long userId) {
        return new ResponseEntity<>(privacySettingsService.getPrivacySettings(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<PrivacySettings> updatePrivacySettings(@PathVariable Long userId, @RequestBody PrivacySettings privacySettings) {
        privacySettings.setUser(new User(userId));
        return new ResponseEntity<>(privacySettingsService.updatePrivacySettings(privacySettings), HttpStatus.OK);
    }
}
