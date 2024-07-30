package com.andromeda.service;

import com.andromeda.dto.PostDTO;
import com.andromeda.entity.Post;
import com.andromeda.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO savePost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        post = postRepository.save(post);
        return modelMapper.map(post, PostDTO.class);
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(value -> modelMapper.map(value, PostDTO.class)).orElse(null);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
