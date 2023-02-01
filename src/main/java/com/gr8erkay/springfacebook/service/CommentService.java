package com.gr8erkay.springfacebook.service;

import com.gr8erkay.springfacebook.model.Comment;
import com.gr8erkay.springfacebook.model.Post;

import java.util.List;

public interface CommentService {
    void updateComment(Comment editedComment);

//    void deleteComment(Comment comment);

    Comment getCommentById(Long id);

    void saveComment(Comment comment);

    List<Comment> findCommentByPost(Post post);

    void deleteComment(Long commentId);

    void deleteAllCommentsInPost(Post post);

}
