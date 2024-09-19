package com.example.medappointdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/Home")
    public String home() {
        return "index"; // This will return index.html
    }

    @GetMapping("/Login")
    public String login() {
        return "login"; // This will return login.html
    }

    @GetMapping("/Register")
    public String register() {
        return "register"; // This will return login.html
    }

    @GetMapping("/Administrator")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/Doctor-dashboard")
    public String doctorDashboard() {
        return "doctor-dashboard";
    }

    @GetMapping("/Patient-dashboard")
    public String patientDashboard() {
        return "patient-dashboard";
    }
}
