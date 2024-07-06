package com.example.andromeda.repository;

import com.example.andromeda.model.PrivacySettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivacySettingsRepository extends JpaRepository<PrivacySettings, Long> {
    PrivacySettings findByUserId(Long userId);
}
