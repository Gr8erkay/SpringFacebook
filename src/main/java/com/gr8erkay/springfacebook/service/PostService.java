package com.gr8erkay.springfacebook.service;

import com.gr8erkay.springfacebook.mapper.LikePosts;
import com.gr8erkay.springfacebook.model.Post;
import com.gr8erkay.springfacebook.model.User;

import java.util.List;

public interface PostService {
    void addPost(User user, Post post);

    List<LikePosts> getAllPost(User user);

    void updatePost(Post post);

    void deletePost(Post post);

    Post getPostById(Long id);
}
