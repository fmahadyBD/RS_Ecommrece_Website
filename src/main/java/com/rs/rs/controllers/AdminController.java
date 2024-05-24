package com.rs.rs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/")
    public String adminDashboard(){


        return "admin/pages/dashboard";
    }
    @GetMapping("/message")
    public String messanger(){


        return "admin/pages/messanger";
    }
    
}
