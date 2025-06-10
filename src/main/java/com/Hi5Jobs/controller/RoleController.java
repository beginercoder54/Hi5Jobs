/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hoang
 */
@Controller
public class RoleController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register-role")
    public String showchooseRole() {
        return "client/rolepage";
    }

    @PostMapping("/register-role")
    public String registerSeeker(@RequestParam("accountID") int accountID,
            @RequestParam("role") int role) {
        registerService.registerRole(accountID, role); // role = 2
        return "redirect:/register-success";
    }
}