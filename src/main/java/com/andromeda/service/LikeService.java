package com.example.andromeda.service;

import com.example.andromeda.model.Like;
import com.example.andromeda.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getPostLikes(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
