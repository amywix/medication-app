//Amy Wickham 121785021
// Amy Wickham 12178502
// File: HomeController.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}