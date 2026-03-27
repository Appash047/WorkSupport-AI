package com.worksupport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller   // ✅ MUST be Controller
public class HomeController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";   // loads login.html
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}