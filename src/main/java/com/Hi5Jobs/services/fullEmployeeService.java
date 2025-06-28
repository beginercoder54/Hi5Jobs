/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.fullinfoEmployee;
import com.Hi5Jobs.repository.FullinfoEmployeeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class fullEmployeeService {

    @Autowired
    private FullinfoEmployeeRepo repo;

    public fullinfoEmployee getByID(int userID) {
        return repo.getByID(userID);
    }

    public List<fullinfoEmployee> getAll() {
        return repo.getAll();
    }

    public void deleteByUserID(int userID, int accountID) {
        repo.deleteByUserID(userID, accountID);
    }
     public List<fullinfoEmployee> searchByKeyword(String keyword) {
         return repo.searchByKeyword(keyword);
     }
}
