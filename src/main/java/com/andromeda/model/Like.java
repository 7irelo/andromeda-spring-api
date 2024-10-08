package com.andromeda.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // getters and setters
}
