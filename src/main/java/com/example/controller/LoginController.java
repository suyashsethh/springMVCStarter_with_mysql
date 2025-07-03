package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UserDAO userDAO = new UserDAO();

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            javax.servlet.http.HttpSession session,
                            Model model) {
        User user = userDAO.findByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("name", user.getName());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        String name = (String) session.getAttribute("name");
        if (name == null) return "redirect:/login";
        model.addAttribute("name", name);
        return "dashboard";
    }
}
