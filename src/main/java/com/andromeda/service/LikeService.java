package com.andromeda.service;

import com.andromeda.dto.LikeDTO;
import com.andromeda.entity.Like;
import com.andromeda.repository.LikeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LikeDTO saveLike(LikeDTO likeDTO) {
        Like like = modelMapper.map(likeDTO, Like.class);
        like = likeRepository.save(like);
        return modelMapper.map(like, LikeDTO.class);
    }

    public List<LikeDTO> getAllLikes() {
        return likeRepository.findAll().stream()
                .map(like -> modelMapper.map(like, LikeDTO.class))
                .collect(Collectors.toList());
    }

    public LikeDTO getLikeById(Long id) {
        Optional<Like> like = likeRepository.findById(id);
        return like.map(value -> modelMapper.map(value, LikeDTO.class)).orElse(null);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
