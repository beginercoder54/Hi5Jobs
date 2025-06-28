/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.FullApplication;
import com.Hi5Jobs.repository.FullApplicationRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullApplicationService {

    @Autowired
    private FullApplicationRepo repo;

    public List<FullApplication> getAll() {
        return repo.getAll();
    }

    public FullApplication getbyID(int resumeID, int userID) {
        return repo.getbyID(resumeID, userID);
    }

    public void deleteByApplicationID(int ApplicationID) {
        repo.deleteByApplicationID(ApplicationID);
    }

    public List<FullApplication> search(String k) {
        return repo.search(k);
    }

    public List<FullApplication> getAppByID(int ID) {
        return repo.getAppByID(ID);
    }
     public int updateApplicationStatus(int applicationID, int status) {
         return repo.updateApplicationStatus(applicationID, status);
     }
}
