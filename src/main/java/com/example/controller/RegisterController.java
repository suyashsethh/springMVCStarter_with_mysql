package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    private UserDAO userDAO = new UserDAO();

    @GetMapping("/register")
    public String showForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        User user = new User(name, email, password);
        int result = userDAO.save(user);
        if (result > 0) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Registration failed.");
            return "register";
        }
    }
}
