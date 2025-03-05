package com.example.demo2.controller;

import java.util.Optional;
import com.example.demo2.Model.User;
import com.example.demo2.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return "redirect:/oauth2/authorization/google"; // Redirect to login
        }
        return "redirect:/check-user"; // Redirect to check user existence
    }

    @GetMapping("/check-user")
    public String checkUser(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return "redirect:/oauth2/authorization/google"; // Redirect if not logged in
         }

        String email = user.getAttribute("email");
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty()) {
            return "redirect:/signup/email=?" + email; // Redirect to signup if user not found
        }

        return "redirect:/dashboard"; // Redirect to index for registered users
    }

    @GetMapping("/home")
    public String index(@AuthenticationPrincipal OAuth2User user, Model model) {
        if (user == null) {
            return "redirect:/oauth2/authorization/google";
        }

        String email = user.getAttribute("email");
        Optional<User> dbUser = userService.getUserByEmail(email);

        if (dbUser.isEmpty()) {
            return "redirect:/signup/email=?" + email;
        }

        model.addAttribute("user", dbUser.get()); // ✅ Show only logged-in user info
        return "dashboard";
    }
}
