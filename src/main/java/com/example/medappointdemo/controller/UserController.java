package com.example.medappointdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/Home")
    public String home() {
        return "index"; // This will return index.html
    }
}
