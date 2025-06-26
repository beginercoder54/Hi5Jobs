/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class JobApplicationMapper implements RowMapper<Application> {

        public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
            Application app = new Application();
            app.setApplicationID(rs.getInt("ApplicationID"));
            app.setResumeID(rs.getInt("resumeID"));
            app.setJobID(rs.getInt("JobID"));
            app.setUserID(rs.getInt("UserID"));

            Timestamp timestamp = rs.getTimestamp("ApplicationDate");
            if (timestamp != null) {
                app.setAppDate(timestamp.toLocalDateTime());
            }

            app.setStatus(rs.getInt("Status"));
            app.setCoverletter(rs.getString("CoverLetter"));
            app.setNotes(rs.getString("Notes"));

            return app;
        }
    }

    public List<Application> getAllByUserID(int userID) {
        String sql = "SELECT * FROM Application WHERE UserID = ?";
        return jdbcTemplate.query(sql, new JobApplicationMapper(), userID);
    }

    public void save(Application app) {
        String sql = "INSERT INTO Application (resumeID, JobID, UserID, ApplicationDate, Status, CoverLetter, Notes) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                app.getResumeID(),
                app.getJobID(),
                app.getUserID(),
                Timestamp.valueOf(app.getAppDate()), // LocalDateTime -> Timestamp
                app.getStatus(),
                app.getCoverletter(),
                app.getNotes()
        );
    }

    public List<Application> getApplicationsByJobID(int jobID) {
        String sql = "SELECT * FROM Application WHERE JobID = ?";
        return jdbcTemplate.query(sql, new JobApplicationMapper(), jobID);
    }

    public String getUsernameByApplicationID(int applicationID) {
        String sql = "SELECT u.Username "
                + "FROM Application a "
                + "JOIN Users u ON a.UserID = u.UserID "
                + "WHERE a.ApplicationID = ?";
        return jdbcTemplate.queryForObject(sql, String.class, applicationID);
    }
}
