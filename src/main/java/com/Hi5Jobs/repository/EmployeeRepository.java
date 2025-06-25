/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Employer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        employer.setCompanyDescription(rs.getNString("CompanyDecription"));
        employer.setTaxcode(rs.getString("TaxCode"));
        employer.setCompanyName(rs.getNString("Companyname"));
        employer.setImgCompany(rs.getBytes("ImgCompany"));  
        return employer;
    }

    public Employer getByID(int userID) {
        String sql = "SELECT * FROM Employer WHERE UserID = ?";
        List<Employer> employers = jdbcTemplate.query(sql, this::mapRow, userID);
        return employers.isEmpty() ? null : employers.get(0);
    }

  
    public void updateEmployer(Employer employer) {
        String sql = "UPDATE Employer SET CompanyName = ?, TaxCode = ?, CompanyDecription = ?, ImgCompany = ? WHERE UserID = ?";
        jdbcTemplate.update(sql,
            employer.getCompanyName(),
            employer.getTaxcode(),
            employer.getCompanyDescription(),
            employer.getImgCompany(),
            employer.getUserID()
        );
    }
}
