/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Job;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
        Job job = new Job();
        job.setJobID(rs.getInt("JobID"));
        job.setUserID(rs.getInt("UserID"));
        job.setTitle(rs.getNString("Title"));
        job.setDescriptionJob(rs.getNString("DecriptionJob"));
        job.setLocation(rs.getNString("Location"));
        job.setSalary(rs.getNString("Salary"));
        job.setRequirement(rs.getNString("Requirement"));
        job.setGentle(rs.getNString("Gentle"));
        job.setNumberofRecruiment(rs.getInt("NumberRecruitment"));
        job.setUploadDate(rs.getDate("UploadDate").toLocalDate());
        job.setStatus(rs.getInt("Status"));
        job.setAge(rs.getNString("Age"));
        job.setSalaryType(rs.getNString("salaryType"));
        return job;
    }

    public void addNewJob(Job job) {
        String sql = "INSERT INTO Job (UserID,Title,DecriptionJob,Location,Salary,Requirement,Gentle,NumberRecruitment,UploadDate,Status,Age,salaryType) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                job.getUserID(),
                job.getTitle(),
                job.getDescriptionJob(),
                job.getLocation(),
                job.getSalary(),
                job.getRequirement(),
                job.getGentle(),
                job.getNumberofRecruiment(),
                job.getUploadDate(),
                job.getStatus(),
                job.getAge(),
                job.getSalaryType());
    }

    public List<Job> getAllJobs() {
        String sql = "SELECT * FROM Job";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public List<Job> getAllJobsbyID(int userID) {
        String sql = "SELECT * FROM Job WHERE UserID = ?";
        return jdbcTemplate.query(sql, this::mapRow,userID);
    }
}
