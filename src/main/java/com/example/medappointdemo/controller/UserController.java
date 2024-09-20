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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationOptions() {
        return "register";
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
    public String registerPatient(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        user.setRole(UserRole.PATIENT);
        return registerUser(user, redirectAttributes);
    }

    @PostMapping("/register/doctor")
    public String registerDoctor(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        user.setRole(UserRole.DOCTOR);
        return registerUser(user, redirectAttributes);
    }

    private String registerUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user, user.getConfirmPassword()); // Pass confirm password
            return "redirect:/login"; // Redirect after successful registration
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/register"; // Redirect back to registration with error
        }
    }
}
