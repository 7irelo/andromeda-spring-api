package com.andromeda.dto;

import java.util.Date;
import java.util.Set;

public class PostDTO {
    private Long id;
    private UserDTO creator;
    private String content;
    private Set<UserDTO> likes;
    private Date created;
    private Date updated;

    // getters and setters
}
