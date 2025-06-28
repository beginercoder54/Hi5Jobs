/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

import com.Hi5Jobs.models.Alert;
import com.Hi5Jobs.models.FullLoveJob;
import com.Hi5Jobs.models.Resume;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.AlertService;
import com.Hi5Jobs.services.FullLoveService;
import com.Hi5Jobs.services.ResumeService;
import com.Hi5Jobs.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hoang
 */
@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private AlertService alertService;
    @Autowired
    private FullLoveService service;
    
    @GetMapping("/profile")
    public String showProfie(HttpSession session, Model model) {
        Integer accountId = (Integer) session.getAttribute("accountID");
        User user = userService.findByAccountId(accountId);
        session.setAttribute("userID", user.getUserID());
        model.addAttribute("user", user);
        Integer userID = user.getUserID();
        List<Resume> resumes = resumeService.getByUserID(userID); // ✅ trả về List<Resume>
        model.addAttribute("resumes", resumes); // ✅ đặt tên đúng: resumes
        Integer userId = (Integer) session.getAttribute("userID");
        List<Alert> a = alertService.getAlertByUserID(userId);
        model.addAttribute("a", a);
        
        List<FullLoveJob> flj = service.getByUserID(userID);
        model.addAttribute("flj", flj);
        return "client/profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address,
            @RequestParam("avatar") MultipartFile avatar,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Integer userId = (Integer) session.getAttribute("userID");
        if (userId == null) {
            return "redirect:/login";
        }

        byte[] imageBytes = null;
        try {
            if (!avatar.isEmpty()) {
                imageBytes = avatar.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setUserID(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setImg(imageBytes); // có thể null nếu người dùng không thay ảnh

        userService.updateUserInfo(user);
        redirectAttributes.addFlashAttribute("alertMessage", "Cập nhật hồ sơ thành công!");
        return "redirect:/profile";
    }

    @PostMapping("/uploadCV")
    private String uploadCV(@RequestParam("cvImage") MultipartFile file, HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID != null && !file.isEmpty()) {
            try {
                byte[] imageBytes = file.getBytes();

                Resume resume = new Resume();
                resume.setUserID(userID);
                resume.setUploadDate(LocalDateTime.now());
                resume.setImgResume(imageBytes); // lưu kiểu byte[] thay vì Image để tiện

                resumeService.save(resume); // Gọi service lưu vào CSDL

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/profile"; // Sau khi upload, quay lại trang hồ sơ
    }

}
