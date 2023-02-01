package com.gr8erkay.springfacebook.dto;


import com.gr8erkay.springfacebook.model.User;
import lombok.Data;

import java.util.List;


@Data
public class ResponseDTO {
    private String message;
    private User data;
    private boolean status;

    private List<User> userList;


}