/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Jobseeker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobseekerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Jobseeker mapRow(ResultSet rs, int rowNum) throws SQLException {
        Jobseeker user = new Jobseeker();
        user.setUserID(rs.getInt("UserID"));
        user.setName(rs.getString("Name"));
        user.setEmail(rs.getString("Email"));
        user.setPhoneNumber(rs.getString("PhoneNumber"));
        user.setAddress(rs.getString("Address"));
        user.setEducation(rs.getString("Education"));
        user.setExperience(rs.getString("Experience"));
        return user;
    }

    public List<Jobseeker> getAllJobSeeker() {
        String sql = "SELECT u.UserID, u.Name, u.Email, u.PhoneNumber, u.Address, "
                + "js.education, js.experience "
                + "FROM Users u JOIN JobSeeker js ON u.UserID = js.UserID ";
        return jdbcTemplate.query(sql, this::mapRow);
    }
    

}
