package com.example.andromeda.service;

import com.example.andromeda.model.UserProfile;
import com.example.andromeda.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUserProfile(Long userId) {
        return userProfileRepository.findByUserId(userId);
    }

    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
