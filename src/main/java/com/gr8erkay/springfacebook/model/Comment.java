package com.gr8erkay.springfacebook.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name = "comments")
//@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentBody;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String comments;

    public Comment(String commentBody, Post post, User user) {
        this.commentBody = commentBody;
        this.post = post;
        this.user = user;
    }
}
