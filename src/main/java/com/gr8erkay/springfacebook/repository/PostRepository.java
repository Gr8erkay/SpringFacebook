package com.gr8erkay.springfacebook.repository;

import com.gr8erkay.springfacebook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByPostIdIsNotNullOrderByPostIdDesc();
    Post findByPostId(Long id);
}