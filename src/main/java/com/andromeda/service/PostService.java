package com.example.andromeda.service;

import com.example.andromeda.model.Post;
import com.example.andromeda.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getUserPosts(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
