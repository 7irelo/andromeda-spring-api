package com.andromeda.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // getters and setters
}
