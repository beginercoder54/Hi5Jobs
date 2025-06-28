/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Fulljobseeker;
import com.Hi5Jobs.models.Job;
import com.Hi5Jobs.models.Resume;
import com.Hi5Jobs.models.fullinfoEmployee;
import com.Hi5Jobs.services.FulljobseekerService;
import com.Hi5Jobs.services.JobService;
import com.Hi5Jobs.services.ResumeService;
import com.Hi5Jobs.services.fullEmployeeService;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private FulljobseekerService fulljobseekerService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private fullEmployeeService repo;
    @Autowired
    private JobService repojob;

    @RequestMapping
    public String showLogin() {
        return "admin/adminlogin";
    }

    @GetMapping("/home")
    public String Login(Model model, HttpSession session) {
        String u = (String) session.getAttribute("user");
        if (u != null) {
            List<Fulljobseeker> e = fulljobseekerService.getAll();
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
            List<Fulljobseeker> e = fulljobseekerService.getAll();
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
            List<fullinfoEmployee> e = repo.getAll();
            model.addAttribute("jobseekers", e);
            model.addAttribute("body", "/WEB-INF/views/admin/homeRe.jsp");
            return "/admin/layout/main";
        }
        return "admin/adminlogin";
    }

    @RequestMapping("/delete-jobseeker")
    public String deletejobseeker(@RequestParam("UserID") int UserID, @RequestParam("accountID") int accountID, Model model) {
        fulljobseekerService.deleteByUserID(UserID, accountID);
        List<Fulljobseeker> e = fulljobseekerService.getAll();
        model.addAttribute("jobseekers", e);
        model.addAttribute("body", "/WEB-INF/views/admin/home.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/view-jobseeker")
    public String viewJobseeker(@RequestParam("userID") int UserID, Model model) {
        Fulljobseeker f = fulljobseekerService.getByUserID(UserID);

        model.addAttribute("jobseekers", f);
        List<Resume> re = resumeService.getByUserID(UserID);
        model.addAttribute("resume", re);
        model.addAttribute("body", "/WEB-INF/views/admin/view.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/view-employee")
    public String viewemp(@RequestParam("userID") int UserID, Model model) {

        fullinfoEmployee e = repo.getByID(UserID);
        model.addAttribute("jobseekers", e);

        Resume re = resumeService.getResumeById(UserID);
        model.addAttribute("re", re);
        model.addAttribute("body", "/WEB-INF/views/admin/view-re.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/delete-employee")
    public String deletemp(@RequestParam("UserID") int UserID, @RequestParam("accountID") int accountID, Model model) {
        repo.deleteByUserID(UserID, accountID);
        List<fullinfoEmployee> e = repo.getAll();
        model.addAttribute("jobseekers", e);
        model.addAttribute("body", "/WEB-INF/views/admin/homeRe.jsp");
        return "/admin/layout/main";

    }

    @RequestMapping("/search-jobseekers")
    public String searchjobseeker(@RequestParam("keyword") String k, Model model) {
        List<Fulljobseeker> f = fulljobseekerService.searchByKeyword(k);
        model.addAttribute("jobseekers", f);
        model.addAttribute("body", "/WEB-INF/views/admin/home.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/search-employee")
    public String searchRE(@RequestParam("keyword") String k, Model model) {
        List<fullinfoEmployee> f = repo.searchByKeyword(k);
        model.addAttribute("jobseekers", f);
        model.addAttribute("body", "/WEB-INF/views/admin/homeRe.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/job")
    public String listJob(Model model, HttpSession session) {
        String u = (String) session.getAttribute("user");
        if (u != null) {
            List<Job> j = repojob.getAllJobs();
            model.addAttribute("jobseekers", j);
            model.addAttribute("body", "/WEB-INF/views/admin/Job.jsp");
            return "/admin/layout/main";
        }
        return "admin/adminlogin";
    }

    @RequestMapping("/delete-job")
    public String deletrjob(@RequestParam("jobID") int jobID, Model model, HttpSession session) {
        String u = (String) session.getAttribute("user");
        if (u != null) {
            repojob.deleteByJobID(jobID);
            List<Job> j = repojob.getAllJobs();
            model.addAttribute("jobseekers", j);
            model.addAttribute("body", "/WEB-INF/views/admin/Job.jsp");
            return "/admin/layout/main";
        }
        return "admin/adminlogin";
    }

    @RequestMapping("/search-job")
    public String searchJob(@RequestParam("keyword") String k, Model model) {
        List<Job> j = repojob.searchJobs(k);
        model.addAttribute("jobseekers", j);
        model.addAttribute("body", "/WEB-INF/views/admin/Job.jsp");
        return "/admin/layout/main";
    }

    @RequestMapping("/manage-cv")
    public String manageCV(Model model) {
        List<Resume> re = resumeService.getAll();
        model.addAttribute("re", re);
        model.addAttribute("body", "/WEB-INF/views/admin/resume.jsp");
        return "/admin/layout/main";
    }

    @GetMapping("/view-resume")
    public String viewJobseekerCV(@RequestParam("userID") int userID,Model model) {
        Resume re = resumeService.getResumeById(userID);
        model.addAttribute("re", re);
         model.addAttribute("body", "/WEB-INF/views/admin/view-resume.jsp");
        return "/admin/layout/main";

    }

}
