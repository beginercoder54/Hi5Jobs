/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.FullinfoJob;
import com.Hi5Jobs.services.FullInfoJobService;
import com.Hi5Jobs.services.JobService;
import com.Hi5Jobs.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private JobService jobService;
    @Autowired
    private UserService userService;
    @Autowired
    private FullInfoJobService fulljobService;



    @RequestMapping("/search")
    public String searchJobs(@RequestParam("query") String keyword, Model model){
        List<FullinfoJob> jobList = fulljobService.searchJob(keyword);
        model.addAttribute("jobs", jobList);
        model.addAttribute("body", "/WEB-INF/views/client/search.jsp");
        return "client/layout/main";
    }
}
