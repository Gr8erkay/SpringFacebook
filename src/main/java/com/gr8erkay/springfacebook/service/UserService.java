package com.gr8erkay.springfacebook.service;

import com.gr8erkay.springfacebook.dto.LoginDTO;
import com.gr8erkay.springfacebook.dto.ResponseDTO;
import com.gr8erkay.springfacebook.model.User;

import java.util.List;

public interface UserService {
    ResponseDTO addUser(User user);

    ResponseDTO loginUser(LoginDTO loginDTO);

    ResponseDTO follow(Long userId);
    ResponseDTO unfollow(Long userId);

    List<User> getAllUser();

}
