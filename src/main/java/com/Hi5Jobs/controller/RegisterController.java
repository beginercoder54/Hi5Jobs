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
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.services.LoginService;
import com.Hi5Jobs.services.RegisterService;
import com.Hi5Jobs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "client/register";
    }

    @PostMapping("/register")
    public String chooseRole(
            @RequestParam("username") String username,
            @RequestParam("fullName") String fullName,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPass,
            Model model) {
        if ("".equals(fullName) || "".equals(phone) || "".equals(password) || "".equals(confirmPass)) {
            model.addAttribute("messages", "Please fill in the information completely!");
            return "client/register";

        } else {
            if (password.equals(confirmPass)) {
                if (loginService.ValidUsername(username) == 1) {
                    model.addAttribute("messages", "Username already exists!");
                    return "client/register";
                }
                if (userService.checkValidPhone(phone) == 1) {
                    model.addAttribute("messages", "Phone number already exists!");
                    return "client/register";
                } else {
                    Account a = new Account();
                    User b = new User();
                    a.setUsername(username);
                    a.setPassword(password);
                    b.setName(fullName);
                    b.setPhoneNumber(phone);
                    int accountID = registerService.registerNew(a, b);

                    return "redirect:/register-role?accountID=" + accountID;
                }

            } else {
                model.addAttribute("messages", "Confirm password is wrong!");
            }

        }
        return "client/register";
    }
}
