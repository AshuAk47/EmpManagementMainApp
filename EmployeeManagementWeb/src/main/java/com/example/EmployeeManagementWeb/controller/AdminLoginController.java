package com.example.EmployeeManagementWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    @GetMapping("/admin-login")
    public String adminLogin() {
        return "admin-login";
    }
}

