/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Application;
import com.Hi5Jobs.repository.ApplicationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationRepository repo;

    public List<Application> getAllByUserID(int userID) {
        return repo.getAllByUserID(userID);
    }

    public void save(Application app) {
        repo.save(app);
    }

    public boolean exists(int userID, int jobID) {
        String sql = "SELECT COUNT(*) FROM Application WHERE UserID = ? AND JobID = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userID, jobID);
        return count != null && count > 0;
    }

    public List<Application> getAll() {
        return repo.getAll();
    }
}
