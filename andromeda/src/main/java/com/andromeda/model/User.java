package com.example.andromeda.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    // Getters and Setters
}
