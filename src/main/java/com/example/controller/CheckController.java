package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckController {

    @RequestMapping("/test")
    @ResponseBody
    public String check() {
        System.out.println("Controller hit");
        return "Spring working!";
    }

    @RequestMapping("/save-user")
    @ResponseBody
    public String saveUser() {
        User user = new User("Debashis", "deb@example.com", "123");
        UserDAO dao = new UserDAO();
        dao.save(user);
        return "User saved!";
    }
}
