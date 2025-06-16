/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Employer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
     public Employer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employer employer = new Employer();
        employer.setUserID(rs.getInt("UserID"));
        employer.setCompanyDescription(rs.getString("CompanyDecription"));
        employer.setTaxcode(rs.getString("CompanyWebsite"));
        return employer;
    }
     
}
