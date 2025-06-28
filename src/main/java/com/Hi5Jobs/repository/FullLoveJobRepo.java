/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.FullLoveJob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FullLoveJobRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FullLoveJob mapRow(ResultSet rs, int rowNum) throws SQLException {
        FullLoveJob job = new FullLoveJob();
        job.setFavoriteJobID(rs.getInt("FavoriteID"));
        job.setUserID(rs.getInt("UserID"));
        job.setJobID(rs.getInt("JobID"));
        job.setTitle(rs.getString("Title"));
        job.setDescriptionJob(rs.getString("DecriptionJob"));
        job.setLocation(rs.getString("Location"));
        job.setSalary(rs.getString("Salary"));
        job.setRequirement(rs.getString("Requirement"));
        job.setGentle(rs.getString("Gentle"));
        job.setNumberofRecruiment(rs.getInt("NumberRecruitment"));

        Date uploadDate = rs.getDate("UploadDate");
        if (uploadDate != null) {
            job.setUploadDate(uploadDate.toLocalDate());
        }

        job.setStatus(rs.getInt("Status"));
        job.setAge(rs.getString("Age"));
        job.setSalaryType(rs.getString("salaryType"));

        return job;
    }

    public List<FullLoveJob> getByUserID(int userID) {
        String sql = "SELECT f.FavoriteID, f.UserID, f.JobID, "
                + "j.Title, j.DecriptionJob, j.Location, j.Salary, j.Requirement, j.Gentle, "
                + "j.NumberRecruitment, j.UploadDate, j.Status, j.Age, j.salaryType "
                + "FROM FavoriteJob f "
                + "JOIN Job j ON f.JobID = j.JobID "
                + "WHERE f.UserID = ?";

        return jdbcTemplate.query(sql,this::mapRow,userID);
    }

}
