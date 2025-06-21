/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.controller;

/**
 *
 * @author hoang
 */
import com.Hi5Jobs.models.Account;
import com.Hi5Jobs.services.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "client/login"; // sẽ gọi login.jsp
    }

    @RequestMapping("/login")
    public String loginprocess(@RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        model.addAttribute("message", "");
        Account acc = loginService.ValidAccount(username, password);
        if (acc != null) {
            
            if (acc.getUserType()== 2 || acc.getUserType()== 3) {
                session.setAttribute("accountID", acc.getAccountID());
                session.setAttribute("userType", acc.getUserType());
                
                return "redirect:/homepage";
            } else {
                model.addAttribute("message", "Tài khoản của bạn không đủ quyền truy cập.");
                return "client/login"; // Quay lại login với thông báo lỗi
            }
        } else {
            model.addAttribute("message", "Username or password is wrong!");
            return "client/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // xóa toàn bộ session
        return "redirect:/homepage"; // quay về trang login (hoặc homepage)
    }

}
