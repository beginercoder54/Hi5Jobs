/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

/**
 *
 * @author hoang
 */
import com.Hi5Jobs.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "client/login"; // sẽ gọi login.jsp
    }

    @RequestMapping("/login")
    public String loginprocess(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        if (loginService.ValidAccount(username, password) == 1) {
             model.addAttribute("message","");
            return "redirect:/homepage";
        } else {
            model.addAttribute("message","Username or password is wrong!");
            return "client/login";
        }
    }

}
