package com.example.EmployeeManagementWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeLoginController {

    @GetMapping("/employee-login")
    public String employeeLogin() {
        return "employee-login";
    }
}
