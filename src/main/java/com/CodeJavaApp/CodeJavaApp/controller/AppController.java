package com.CodeJavaApp.CodeJavaApp.controller;

import com.CodeJavaApp.CodeJavaApp.model.User;
import com.CodeJavaApp.CodeJavaApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignupFrom(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user){
      repo.save(user);
      return "register_success";
    }

}
