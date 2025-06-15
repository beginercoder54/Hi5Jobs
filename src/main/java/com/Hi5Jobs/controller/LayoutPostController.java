/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LayoutPostController {
    
    @GetMapping("/post")
    public String show(Model model){
        model.addAttribute("body", "/WEB-INF/views/client/postForm.jsp");
        return "client/layoutPost/main";
    }
}
