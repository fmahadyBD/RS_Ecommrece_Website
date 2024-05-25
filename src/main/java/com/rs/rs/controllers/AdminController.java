package com.rs.rs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rs.rs.models.Messages;
import com.rs.rs.services.MessageService;

@Controller
public class AdminController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String adminDashboard() {

        return "admin/pages/dashboard";
    }

    @GetMapping("/message")
    public String addMesg(Model model) {
        model.addAttribute("abc", new Messages());
        return "admin/pages/messenger";
    }

    @PostMapping("/message")
    public String addMessage(@ModelAttribute("abc") Messages messages) {
        try {
            messageService.create(messages);
    
            return "redirect:/message"; 
        } catch (Exception e) {
            e.printStackTrace();
            return "admin/pages/home";
        }
    }

}
