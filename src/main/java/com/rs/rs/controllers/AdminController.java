package com.rs.rs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rs.rs.dao.MessageRepository;
import com.rs.rs.models.Messages;
import com.rs.rs.services.MessageService;

import jakarta.validation.Valid;

@Controller
public class AdminController {


 

    @GetMapping("/")
    public String adminDashboard() {

        return "admin/pages/dashboard";
    }

    @Autowired
    private MessageRepository repo;

    @GetMapping("/message")
    public String addMesg(Model model) {
        List<Messages> messages=repo.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("abc", new Messages());
        return "admin/pages/messenger";
    }




    @Autowired
    private MessageService messageService;
   
    @PostMapping("/message")
    public String addMessage(@Valid @ModelAttribute("abc") Messages messages,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Messages> messageList = repo.findAll();
            model.addAttribute("messages", messageList);
            model.addAttribute("abc", messages); // Use the object containing validation errors
            return "admin/pages/messenger";
        }
        try {
            messageService.create(messages);
            return "redirect:/message";
        } catch (Exception e) {
            e.printStackTrace();
            return "admin/pages/home";
        }
    }

}
