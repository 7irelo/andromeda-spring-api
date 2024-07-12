package com.example.andromeda.model;

import javax.persistence.*;

@Entity
public class PrivacySettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isProfilePrivate;

    private boolean canReceiveMessages;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Getters and Setters
}
