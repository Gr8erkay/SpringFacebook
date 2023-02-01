package com.gr8erkay.springfacebook.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@RequiredArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long friend_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
