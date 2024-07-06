package com.example.andromeda.service;

import com.example.andromeda.model.PrivacySettings;
import com.example.andromeda.repository.PrivacySettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivacySettingsService {

    @Autowired
    private PrivacySettingsRepository privacySettingsRepository;

    public PrivacySettings getPrivacySettings(Long userId) {
        return privacySettingsRepository.findByUserId(userId);
    }

    public PrivacySettings updatePrivacySettings(PrivacySettings privacySettings) {
        return privacySettingsRepository.save(privacySettings);
    }
}
