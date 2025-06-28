/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Alert;
import com.Hi5Jobs.models.Application;
import com.Hi5Jobs.models.FavoriteJob;
import com.Hi5Jobs.models.FullinfoJob;
import com.Hi5Jobs.models.Resume;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.repository.FavoriteJobRepo;
import com.Hi5Jobs.services.AlertService;
import com.Hi5Jobs.services.ApplicationService;
import com.Hi5Jobs.services.FullInfoJobService;
import com.Hi5Jobs.services.FullLoveService;
import com.Hi5Jobs.services.ResumeService;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {

    @Autowired
    private FullInfoJobService infoService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private UserService userService;
    @Autowired
    private AlertService alertService;
    @Autowired
    private FullLoveService fullloveService;
    @Autowired
    private FavoriteJobRepo repo;

    @GetMapping("/info")
    public String showInfo(@RequestParam("jobID") int jobID, @RequestParam("UserID") int UserID, Model model, HttpSession session) {
        FullinfoJob job = infoService.findByID(jobID);
        model.addAttribute("job", job);
        model.addAttribute("body", "/WEB-INF/views/client/info.jsp");
        session.setAttribute("EmployeeID", UserID);
        List<FullinfoJob> relatedJob = infoService.findByUserID(UserID, jobID);
        model.addAttribute("relatedJobs", relatedJob);
        Integer accountId = (Integer) session.getAttribute("accountID");
        if (accountId != null) {
            Integer userId = (Integer) session.getAttribute("userId");
            List<Resume> resume = resumeService.getByUserID(userId);
            model.addAttribute("savedCVs", resume);
        }

        return "client/layout/main";
    }

    @PostMapping("/apply-job")
    public String applyJob(HttpServletResponse response, HttpSession session, @RequestParam("jobID") int jobID, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("cvFileID") int resumeID) throws IOException {

        Application app = new Application();
        Integer accountId = (Integer) session.getAttribute("accountID");
        User user = userService.findByAccountId(accountId);

        if (applicationService.exists(user.getUserID(), jobID)) {
            response.getWriter().write("<script>alert('Bạn đã nộp hồ sơ cho công việc này rồi!'); window.history.back();</script>");
            return null;
        }

        app.setUserID(user.getUserID());
        app.setCoverletter(subject);
        app.setNotes(message);
        app.setResumeID(resumeID);
        app.setStatus(0);
        app.setJobID(jobID);
        app.setAppDate(LocalDateTime.now());
        applicationService.save(app);

        Alert a = new Alert();
        Integer id = (Integer) session.getAttribute("EmployeeID");

        a.setNameUser(user.getName());
        a.setMessage("Đã nộp hồ sơ xin việc");
        a.setDate(LocalDateTime.now());
        a.setUserID(id);

        alertService.addAlert(a);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(
                "<script>alert('Nộp thành công.'); window.history.back();</script>");
        return null;
    }

    @RequestMapping("/addFavorite")
    public String addFavorite(HttpServletResponse response, @RequestParam("jobID") int jobID, Model model, HttpSession session) throws IOException {

        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            if (repo.isFavoriteExisted(jobID, userId) == true) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write(
                        "<script>alert('Đã có trong mục yêu thích.'); window.history.back();</script>");
                return null;
            }
            FavoriteJob a = new FavoriteJob();
            a.setJobID(jobID);
            a.setUserID(userId);
            repo.addFavorite(a);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(
                    "<script>alert('Thêm danh sách yêu thích thành công.'); window.history.back();</script>");
            return null;
        }
        return "redirect:/login";
    }
}
