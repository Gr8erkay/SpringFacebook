package com.gr8erkay.springfacebook.repository;

import com.gr8erkay.springfacebook.model.Post;
import com.gr8erkay.springfacebook.model.PostLikes;
import com.gr8erkay.springfacebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LikeRepository extends JpaRepository<PostLikes, Long> {
    @Transactional
    void deletePostLikesByPostAndUser(Post post, User user);

    List<PostLikes> findAllByPost(Post post);

    void deleteAllByPost(Post post);
}
