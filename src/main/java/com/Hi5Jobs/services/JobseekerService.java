/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Jobseeker;
import com.Hi5Jobs.repository.JobseekerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobseekerService {
    @Autowired
    private JobseekerRepository repo;
    
    public List<Jobseeker> getAllJobSeeker() {
        return repo.getAllJobSeeker();
    }
}
