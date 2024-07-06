package com.example.andromeda.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Getters and Setters
}
