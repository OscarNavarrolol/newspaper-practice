package com.newspaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/v1")
    public String principalPage() {
        return "principal";
    }

    @GetMapping("/login")
    public String loginPage () {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage () {
        return "register";
    }

    @GetMapping("/principal")
    public String homePage(){
        return "principalPage";
    }

}
