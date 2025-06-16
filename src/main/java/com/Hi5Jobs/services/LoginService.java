/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Account;
import com.Hi5Jobs.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */
@Service
public class LoginService {
    
    @Autowired
    private LoginRepository repo;
    
     
    public Account ValidAccount(String username,String password){
        return repo.ValidAccount(username, password);
    }
    public int ValidUsername(String username){
        return repo.ValidUsername(username);
    }
}
