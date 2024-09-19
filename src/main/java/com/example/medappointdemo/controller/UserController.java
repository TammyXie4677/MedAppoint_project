package com.example.medappointdemo.controller;

import com.example.medappointdemo.entity.User;
import com.example.medappointdemo.entity.UserRole;
import com.example.medappointdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index"; // This will return index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // This will return login.html
    }

    @GetMapping("/register")
    public String showRegistrationOptions() {
        return "register"; // Landing page with options
    }

    @GetMapping("/register/patient")
    public String showPatientRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register_patient"; // Patient registration form
    }

    @GetMapping("/register/doctor")
    public String showDoctorRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register_doctor"; // Doctor registration form
    }

    @PostMapping("/register/patient")
    public String registerPatient(@ModelAttribute("user") User user) {
        user.setRole(UserRole.PATIENT);
        userService.registerUser(user);
        return "redirect:/login"; // Redirect after successful registration
    }

    @PostMapping("/register/doctor")
    public String registerDoctor(@ModelAttribute("user") User user) {
        user.setRole(UserRole.DOCTOR);
        userService.registerUser(user);
        return "redirect:/login"; // Redirect after successful registration
    }
}
