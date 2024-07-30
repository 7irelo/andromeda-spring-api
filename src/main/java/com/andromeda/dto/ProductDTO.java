package com.andromeda.dto;

import java.util.Date;
import java.util.Set;

public class ProductDTO {
    private Long id;
    private UserDTO creator;
    private String name;
    private String description;
    private double price;
    private Set<UserDTO> likes;
    private Date created;
    private Date updated;

    // getters and setters
}
