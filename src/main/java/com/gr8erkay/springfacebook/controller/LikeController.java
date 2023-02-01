package com.gr8erkay.springfacebook.controller;

import com.gr8erkay.springfacebook.service.LikeService;
import com.gr8erkay.springfacebook.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/like_post")
    public @ResponseBody String likePost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("logUser");

        Long postId = Long.parseLong(request.getParameter("postId"));
        String action = request.getParameter("action");
        if(likeService.likePost(user, postId, action)){
            return "successful";
        }else{
            session.setAttribute("message", "server error");
        }
        return "";
    }
}
