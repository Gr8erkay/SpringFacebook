package com.gr8erkay.springfacebook.controller;


import com.gr8erkay.springfacebook.dto.LoginDTO;
import com.gr8erkay.springfacebook.dto.ResponseDTO;
import com.gr8erkay.springfacebook.service.UserService;
import com.gr8erkay.springfacebook.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }




    @PostMapping("/register")
    public String registerUser(User user, Model model, RedirectAttributes redirectAttributes) {
        ResponseDTO response = userService.addUser(user);

        if (response.isStatus()) {
            redirectAttributes.addFlashAttribute("message", response.getMessage());
            return "redirect:/";
        }
        model.addAttribute("message", response.getMessage());
        return "register";

    }


    @GetMapping("/")
    public String getLogInPage(Model model) {
        model.addAttribute("user", new LoginDTO());
        return "index";
    }



    @PostMapping("/login")
    public String loginUser(LoginDTO loginDTO, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResponseDTO response = userService.loginUser(loginDTO);
        if (response.isStatus()) {
            redirectAttributes.addFlashAttribute("message", response.getMessage());
            redirectAttributes.addFlashAttribute("user", response.getData());
            session.setAttribute("logUser", response.getData());
            return "redirect:/home";
        }
        model.addAttribute("message", response.getMessage());
        return "index";

    }

    /**
     * Method to get the logout page
     */
    @GetMapping("/logout")
    public String logUserOut(Model model, HttpSession httpSession) {

        if (httpSession != null) {
            httpSession.invalidate();
        }

        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        return "redirect:/";

    }
    @GetMapping("/all-users")
    public String getAllUsers (Model model, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("logUser");
        if (user==null) return "redirect:/";
        List<User> users = userService.getAllUser();
        model.addAttribute("all-users", users);

        return "all-users";

    }

}
