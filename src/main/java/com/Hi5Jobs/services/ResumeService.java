/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Resume;
import com.Hi5Jobs.repository.ResumeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository repo;
    
    public List<Resume> getByUserID(int userID) {
        return repo.getListByUserID(userID);
    }
    public void save(Resume resume){
        repo.save(resume);
    }
     public Resume getResumeById(int resumeID) {
         return repo.getResumeById(resumeID);
     }
      public List<Resume> getAll() {
          return repo.getAll();
      }
}
