package com.example.andromeda.service;

import com.example.andromeda.model.Media;
import com.example.andromeda.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public List<Media> getUserMedia(Long userId) {
        return mediaRepository.findByUserId(userId);
    }

    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
