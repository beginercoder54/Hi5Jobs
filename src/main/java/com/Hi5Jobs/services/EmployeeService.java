/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Employer;
import com.Hi5Jobs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    
    public Employer getByID(int UserID){
        return repo.getByID(UserID);
    }
    public void update(Employer employer){
        repo.updateEmployer(employer);
    }
}
