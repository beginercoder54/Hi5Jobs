/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.FullinfoJob;
import com.Hi5Jobs.repository.FullInfoJobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullInfoJobService {

    @Autowired
    private FullInfoJobRepository repo;

    public List<FullinfoJob> getAllActiveJobsWithEmployerInfo() {
        return repo.getAllJobsWithEmployerInfo();
    }

    public List<FullinfoJob> searchJob(String keyword) {
        return repo.searchJobs(keyword);
    }

    public FullinfoJob findByID(int jobID) {
        return repo.findByID(jobID);
    }
     public List<FullinfoJob> findByUserID(int UserID,int jobID) {
         return repo.findByUserID(UserID,jobID);
     }
}
