package com.example.demo2.controller;

import com.example.demo2.Model.User;
import com.example.demo2.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signupPage(@RequestParam(required = false) String email, Model model) {
        model.addAttribute("email", email);
        return "signup/email=?"+ email;
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user); // ✅ Save new user to the database
        return "redirect:/";
    }
}
