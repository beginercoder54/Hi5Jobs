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
import com.Hi5Jobs.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @GetMapping("/register")
    public String showRegisterPage() {
        return "client/register";
    }
    
   @RequestMapping("/register")
   public String chooseRole(
           @RequestParam("username") String username,
           @RequestParam("fullName") String fullName,
           @RequestParam("phone") String phone,
           @RequestParam("password") String password,
           @RequestParam("confirmPassword") String confirmPass){
       if("".equals(fullName) || "".equals(phone) || "".equals(password) || "".equals(confirmPass) ){
           return "redirect:/register";
       
        }
       else {
           if(password.equals(confirmPass)){
               Account a= new Account();
               User b = new User();
               a.setUsername(username);
               a.setPassword(password);
               b.setName(fullName);
               b.setPhoneNumber(phone);
              int accountID = registerService.registerNew(a, b);
              
              return "redirect:/register-role?accountID=" + accountID;
           }
           return "redirect:/register";
       }
   }
}
