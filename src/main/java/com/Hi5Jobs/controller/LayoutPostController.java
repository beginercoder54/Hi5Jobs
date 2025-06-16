/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Job;
import java.time.LocalDate;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.JobService;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LayoutPostController {

    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @GetMapping("/post")
    public String show(Model model) {
        model.addAttribute("body", "/WEB-INF/views/client/postForm.jsp");
        return "client/layoutPost/main";
    }

    @PostMapping("/post")
    public String add(@RequestParam("jobTitle") String jobTitle,
            @RequestParam("location") String location,
            @RequestParam("description") String description,
            @RequestParam("salaryType") String salaryType,
            @RequestParam("gender") String gender,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("age") String age,
            @RequestParam("requirementNote") String requirementNote,
            @RequestParam("salaryFrom") String salaryFrom,
            @RequestParam("salaryTo") String salaryTo,
            HttpSession session,
            Model model) {


            int accountID = (Integer) session.getAttribute("accountID");
            User user = userService.findByAccountId(accountID);
            Job job = new Job();
            job.setUserID(user.getUserID());
            job.setTitle(jobTitle);
            job.setLocation(location);
            job.setDescriptionJob(description);
            job.setSalaryType(salaryType);
            job.setGentle(gender);
            job.setNumberofRecruiment(quantity);
            job.setAge(age);
            job.setRequirement(requirementNote);
            job.setSalary(salaryFrom + "-" + salaryTo);
            job.setUploadDate(LocalDate.now());
            job.setStatus(1);
            
            jobService.addNewJob(job);
            model.addAttribute("success", true);

        return "redirect:/post";
    }
}
