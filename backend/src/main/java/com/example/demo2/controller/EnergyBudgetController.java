package com.example.demo2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

import com.example.demo2.Model.EnergyBudget;
import com.example.demo2.Model.User;
import com.example.demo2.EnergyBudgetService;
import com.example.demo2.UserService;

@Controller
public class EnergyBudgetController {

    private final EnergyBudgetService energyBudgetService;
    private final UserService userService;

    // ✅ Constructor-based Dependency Injection (No @Autowired needed)
    public EnergyBudgetController(EnergyBudgetService energyBudgetService, UserService userService) {
        this.energyBudgetService = energyBudgetService;
        this.userService = userService;
    }

    @GetMapping("/energy-budgets")
    public String getUserEnergyBudgets(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }

        // ✅ Get logged-in user's email
        String email = principal.getAttribute("email");
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()) {
            // ✅ Fetch energy budgets using email
            List<EnergyBudget> userBudgets = energyBudgetService.getEnergyBudgetsByEmail(email);

            // ✅ Debugging
            System.out.println("Fetching Energy Budgets for Email: " + email);
            System.out.println("Budgets found: " + userBudgets);

            model.addAttribute("energyBudgets", userBudgets);
            return "dashboard"; // Renders dashboard.html
        } else {
            return "redirect:/signup?email=" + email;
        }
    }
}
