/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.User;
import com.Hi5Jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public int checkValidPhone(String Phone){
        return repo.checkPhoneNumber(Phone);
    }
    
      public User findByAccountId(int accountId) {
        return repo.findByAccountId(accountId);
    }
}
