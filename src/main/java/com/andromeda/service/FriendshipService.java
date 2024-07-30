package com.andromeda.service;

import com.andromeda.dto.FriendshipDTO;
import com.andromeda.entity.Friendship;
import com.andromeda.repository.FriendshipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FriendshipDTO saveFriendship(FriendshipDTO friendshipDTO) {
        Friendship friendship = modelMapper.map(friendshipDTO, Friendship.class);
        friendship = friendshipRepository.save(friendship);
        return modelMapper.map(friendship, FriendshipDTO.class);
    }

    public List<FriendshipDTO> getAllFriendships() {
        return friendshipRepository.findAll().stream()
                .map(friendship -> modelMapper.map(friendship, FriendshipDTO.class))
                .collect(Collectors.toList());
    }

    public FriendshipDTO getFriendshipById(Long id) {
        Optional<Friendship> friendship = friendshipRepository.findById(id);
        return friendship.map(value -> modelMapper.map(value, FriendshipDTO.class)).orElse(null);
    }

    public void deleteFriendship(Long id) {
        friendshipRepository.deleteById(id);
    }
}
