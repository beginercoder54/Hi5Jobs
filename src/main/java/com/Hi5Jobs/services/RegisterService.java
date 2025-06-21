/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Account;
import com.Hi5Jobs.models.User;
import com.Hi5Jobs.repository.RegisterRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */
@Service
public class RegisterService {
    @Autowired
    private RegisterRepository repo;

    public int registerNew(Account account, User user) throws IOException{
         return repo.registerNew(account, user);
    }
    public void registerRole(int accountID, int userType){
        repo.updateUserType(accountID,userType);
    }
}
