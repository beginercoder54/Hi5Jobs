/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Employee;
import com.Hi5Jobs.models.Jobseeker;
import com.Hi5Jobs.repository.ERepository;
import com.Hi5Jobs.services.JobseekerService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private JobseekerService jobseekerService;
    @Autowired
    private ERepository repo;

    @RequestMapping
    public String showLogin() {
        return "admin/adminlogin";
    }

    @GetMapping("/home")
    public String Login(Model model, HttpSession session) {
        String u = (String) session.getAttribute("user");
        if (u != null) {
            List<Jobseeker> e = jobseekerService.getAllJobSeeker();
            model.addAttribute("jobseekers", e);
            model.addAttribute("body", "/WEB-INF/views/admin/home.jsp");
            return "/admin/layout/main";
        }
        model.addAttribute("messages", "Username or password is wrong!");
        return "admin/adminlogin";
    }

    @PostMapping("/home")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("user", username);
            List<Jobseeker> e = jobseekerService.getAllJobSeeker();
            model.addAttribute("jobseekers", e);
            model.addAttribute("body", "/WEB-INF/views/admin/home.jsp");
            return "/admin/layout/main";
        }
        model.addAttribute("messages", "Username or password is wrong!");
        return "admin/adminlogin";
    }

    @RequestMapping("/homeRe")
    public String homeRe(Model model, HttpSession session) {
        String u = (String) session.getAttribute("user");
        if (u != null) {
            List<Employee> e = repo.getAllJobSeeker();
            model.addAttribute("jobseekers", e);
            model.addAttribute("body", "/WEB-INF/views/admin/homeRe.jsp");
            return "/admin/layout/main";
        }
        return "admin/adminlogin";
    }

}
