package com.newspaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/v1")
    public String principalPage(Model model) {
        return "principal";
    }

    @GetMapping("/login")
    public String loginPage (Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage (Model model) {
        return "register";
    }

    @GetMapping("/principal")
    public String homePage(){
        return "principalPage";
    }

}
