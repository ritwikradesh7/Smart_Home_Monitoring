package com.example.demo2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import com.example.demo2.Model.Device;
import com.example.demo2.Model.User;
import com.example.demo2.DeviceService;
import com.example.demo2.UserService;

@Controller
public class DeviceControllerr {

    private final DeviceService deviceService;
    private final UserService userService;

    // ✅ Constructor-based Dependency Injection (No @Autowired needed)
    public DeviceControllerr(DeviceService deviceService, UserService userService) {
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @GetMapping("/devices")
    public String getUserDevices(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
      // ✅ Get the logged-in user's email
        String email = principal.getAttribute("email");
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()) {
            // ✅ Fetch devices using email
            List<Device> userDevices = deviceService.getDevicesByEmail(email);

            // ✅ Debugging
            System.out.println("Fetching devices for Email: " + email);
            System.out.println("Devices found: " + userDevices);

            model.addAttribute("devices", userDevices);
            return "dashboard"; // Renders index.html
        } else {
            return "redirect:/signup?email=" + email;
        }
    }
}
