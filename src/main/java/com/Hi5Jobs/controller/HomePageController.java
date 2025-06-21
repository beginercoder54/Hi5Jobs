/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Job;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.JobService;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
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
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/homepage"})
    public String showLoginPage(HttpSession session, Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        if (accountId != null) {
            User user = userService.findByAccountId(accountId); // tìm theo accountID
            if (user != null && user.getImg() != null) {
                String base64Image = Base64.getEncoder().encodeToString(user.getImg());
            }
            model.addAttribute("user", user);
        }
        List<Job> jobList = jobService.getAllJobs(); // Trả về danh sách Job
        model.addAttribute("jobs", jobList);
        model.addAttribute("body", "/WEB-INF/views/client/homepage.jsp");
        return "client/layout/main"; // sẽ gọi login.jsp
    }

    @RequestMapping("/recruiterhomepage")
    public String changeRecruiterPage(HttpSession session,Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        if (accountId != null) {
            User user = userService.findByAccountId(accountId); // tìm theo accountID
            if (user != null && user.getImg() != null) {
                String base64Image = Base64.getEncoder().encodeToString(user.getImg());
            }
            model.addAttribute("user", user);
        }
        model.addAttribute("body", "/WEB-INF/views/client/homeRecruiter.jsp");
        return "client/layoutRecruiter/main";
    }

}
