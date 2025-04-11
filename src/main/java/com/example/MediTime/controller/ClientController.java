/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

package com.example.MediTime.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amywi
 */
@RestController
public class ClientController {

    @RequestMapping("/url2")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }

}
