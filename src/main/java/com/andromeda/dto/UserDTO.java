package com.andromeda.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String avatar;
    private String bio;
    private Set<UserDTO> friends;

    // getters and setters
}
