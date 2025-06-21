/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hoang
 */
@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/profile")
    public String showProfie(HttpSession session, Model model){
        Integer accountId = (Integer) session.getAttribute("accountID");
        User user= userService.findByAccountId(accountId);
        session.setAttribute("userID", user.getUserID());
        model.addAttribute("user", user);
        return "client/profile";
    }
}
