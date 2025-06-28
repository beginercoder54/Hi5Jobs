/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Report;
import com.Hi5Jobs.repository.ReportRepo;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepo repo;
    
    public Report countStats(LocalDate from, LocalDate to) {
        return repo.countStats(from, to);
    }
}
