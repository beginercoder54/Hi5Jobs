/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ERepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employer = new Employee();
        employer.setUserID(rs.getInt("UserID"));
        employer.setName(rs.getString("Name"));
        employer.setEmail(rs.getString("Email"));
        employer.setPhoneNumber(rs.getString("PhoneNumber"));
        employer.setAddress(rs.getString("Address"));
        employer.setCompanyDescription(rs.getString("CompanyDecription"));
        employer.setCompanyName(rs.getString("Companyname"));
        employer.setTaxcode(rs.getString("Taxcode"));
        return employer;
    }

    public List<Employee> getAllJobSeeker() {
        String sql = "SELECT u.UserID, u.Name, u.Email, u.PhoneNumber, u.Address, "
                + "js.CompanyDecription, js.Companyname,js.TaxCode "
                + "FROM Users u JOIN Employer js ON u.UserID = js.UserID ";
        return jdbcTemplate.query(sql, this::mapRow);
    }

}
