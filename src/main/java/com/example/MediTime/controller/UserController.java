package com.example.meditime.controller;

import com.example.meditime.model.User;
import com.example.meditime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user, Model model) {
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists.");
            return "signup";
        }

        userService.addUser(user.getName(), user.getEmail(), user.getPassword(), "Carer");
        return "redirect:/download";
    }

    @GetMapping("/download")
    public String showDownloadPage() {
        return "download";
    }
}
