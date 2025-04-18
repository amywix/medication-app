package com.example.meditime.controller;

import com.example.meditime.model.User;
import com.example.meditime.repository.UserRepository;
import com.example.meditime.security.JwtUtil;
import com.example.meditime.service.UserService;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
        @Autowired
    private UserRepository userRepository;
    @Autowired
private JwtUtil jwtUtil;


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

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

 

@PostMapping("/login")
public Map<String, String> login(@RequestBody Map<String, String> request) {
    String email = request.get("email");
    String password = request.get("password");

    Optional<User> user = userRepository.findByEmail(email);
    if (user.isEmpty() || !user.get().getPassword().equals(password)) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    String token = jwtUtil.generateToken(email);
    return Map.of("token", token, "name", user.get().getName(), "role", user.get().getRole().toString());
}

    @GetMapping("/download")
    public String showDownloadPage() {
        return "download";
    }
}
