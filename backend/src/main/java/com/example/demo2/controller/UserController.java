package com.example.demo2.controller;

import com.example.demo2.Model.User;
import com.example.demo2.Model.Device;
import com.example.demo2.Model.EnergyBudget;
import com.example.demo2.UserService;
import com.example.demo2.DeviceService;
import com.example.demo2.EnergyBudgetService;
import com.example.demo2.repository.EnergyBudgetRepository; // ✅ Import Repository

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;
    private final DeviceService deviceService;
    private final EnergyBudgetService energyBudgetService;
    private final EnergyBudgetRepository energyBudgetRepository; // ✅ Inject Repository

    public UserController(UserService userService, DeviceService deviceService, 
                          EnergyBudgetService energyBudgetService, EnergyBudgetRepository energyBudgetRepository) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.energyBudgetService = energyBudgetService;
        this.energyBudgetRepository = energyBudgetRepository; // ✅ Initialize
    }

    @GetMapping("/dashboard")
    public String userDashboard(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }

        String email = principal.getAttribute("email");
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()) {
            User loggedInUser = user.get();
            model.addAttribute("user", loggedInUser);

            // ✅ Fetch devices for this user
            List<Device> userDevices = deviceService.getDevicesByEmail(loggedInUser.getEmail());
            model.addAttribute("devices", userDevices);

            // ✅ Fetch energy budgets for this user
            List<EnergyBudget> userBudgets = energyBudgetService.getEnergyBudgetsByEmail(loggedInUser.getEmail());
            model.addAttribute("energyBudgets", userBudgets);

            // ✅ Calculate total energy consumption from all devices
            double totalEnergyConsumed = userDevices.stream()
                    .mapToDouble(Device::getEnergyConsumption_kWh)
                    .sum();

            // ✅ Check if budget is exceeded and update alert status
            boolean alertTriggered = false;
            for (EnergyBudget budget : userBudgets) {
                if (totalEnergyConsumed > budget.getEnergyBudget_kWh()) {
                    alertTriggered = true;
                    budget.setAlertStatus(true); // Update alert status
                    energyBudgetRepository.save(budget); // ✅ Correct method to save update
                }
            }

            model.addAttribute("totalEnergyConsumed", totalEnergyConsumed);
            model.addAttribute("alertTriggered", alertTriggered);

            return "dashboard"; // Render dashboard.html
        } else {
            return "redirect:/signup?email=" + email;
        }
    }
}
