/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Job;
import com.Hi5Jobs.services.JobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoang
 */
@Controller
public class HomePageController {
    
    @Autowired
    private JobService jobService;
    @RequestMapping({"/","/homepage"})
    public String showLoginPage(Model model) {
         List<Job> jobList = jobService.getAllJobs(); // Trả về danh sách Job
        model.addAttribute("jobs", jobList);
        model.addAttribute("body","/WEB-INF/views/client/homepage.jsp");
        return "client/layout/main"; // sẽ gọi login.jsp
    }
    
    @RequestMapping("/recruiterhomepage")
    public String changeRecruiterPage(Model model){
        model.addAttribute("body","/WEB-INF/views/client/homeRecruiter.jsp");
        return "client/layoutRecruiter/main";
    }
   
}
