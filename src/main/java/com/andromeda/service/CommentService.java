package com.andromeda.service;

import com.andromeda.dto.CommentDTO;
import com.andromeda.entity.Comment;
import com.andromeda.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        comment = commentRepository.save(comment);
        return modelMapper.map(comment, CommentDTO.class);
    }

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
    }

    public CommentDTO getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(value -> modelMapper.map(value, CommentDTO.class)).orElse(null);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
