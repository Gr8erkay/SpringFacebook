package com.gr8erkay.springfacebook.service;


import com.gr8erkay.springfacebook.model.Post;
import com.gr8erkay.springfacebook.model.User;

public interface LikeService {
    boolean likePost(User user, Long postId, String action);
    void deleteAllLikesInPost(Post post);
}
