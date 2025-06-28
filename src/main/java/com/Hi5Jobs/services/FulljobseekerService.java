/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Fulljobseeker;
import com.Hi5Jobs.repository.FulljobseekerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FulljobseekerService {

    @Autowired
    private FulljobseekerRepo repo;

    public Fulljobseeker getByUserID(int userID) {
        return repo.getByUserID(userID);
    }

    public List<Fulljobseeker> getAll() {
        return repo.getAll();
    }
     public void deleteByUserID(int userID, int accountID) {
         repo.deleteByUserID(userID, accountID);
     }
       public List<Fulljobseeker> searchByKeyword(String keyword) {
           return repo.searchByKeyword(keyword);
       }
}
