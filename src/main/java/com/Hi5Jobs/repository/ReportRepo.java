/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Report;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
        Report stats = new Report();
        stats.setTotalJ(rs.getInt("TotalJ"));
        stats.setTotalE(rs.getInt("TotalE"));
        stats.setTotalJob(rs.getInt("TotalJob"));
        stats.setApplication(rs.getInt("Application"));
        stats.setJob(rs.getInt("Job"));
        stats.setResume(rs.getInt("Resume"));
        return stats;
    }

    public Report countStats(LocalDate from, LocalDate to) {
        String sql = "SELECT "
                + "(SELECT COUNT(*) FROM Jobseeker) AS TotalJ, "
                + "(SELECT COUNT(*) FROM Employer) AS TotalE, "
                + "(SELECT COUNT(*) FROM Job) AS TotalJob, "
                + "(SELECT COUNT(*) FROM Application WHERE ApplicationDate BETWEEN ? AND ?) AS Application, "
                + "(SELECT COUNT(*) FROM Job WHERE UploadDate BETWEEN ? AND ?) AS Job, "
                + "(SELECT COUNT(*) FROM Resume WHERE UploadDate BETWEEN ? AND ?) AS Resume";

        return jdbcTemplate.queryForObject(sql, this::mapRow,
                Date.valueOf(from), Date.valueOf(to), // For Application
                Date.valueOf(from), Date.valueOf(to), // For Job
                Date.valueOf(from), Date.valueOf(to) // For Resume
        );
    }

}
