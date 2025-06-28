/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.FullApplication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FullApplicationRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FullApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        FullApplication app = new FullApplication();

        app.setApplicationID(rs.getInt("ApplicationID"));
        app.setJobID(rs.getInt("JobID"));
        app.setUserID(rs.getInt("userID"));
        app.setAppDate(rs.getTimestamp("ApplicationDate").toLocalDateTime());
        app.setCoverletter(rs.getString("CoverLetter"));
        app.setNotes(rs.getString("Notes"));
        app.setResumeID(rs.getInt("resumeID"));
        app.setImgResume(rs.getBytes("fileResume")); // fileResume là ảnh CV (byte[])
        app.setUploadDate(rs.getTimestamp("uploadDate").toLocalDateTime());
        app.setStatus(rs.getInt("Status")); // nếu có
        app.setName(rs.getString("Name"));
        app.setEmail(rs.getString("Email"));
        app.setPhoneNumber(rs.getString("PhoneNumber"));
        app.setAddress(rs.getString("Address"));

        app.setEducation(rs.getString("Education"));
        app.setExperience(rs.getString("Experience"));

        return app;
    }

    public List<FullApplication> getAll() {
        String sql = "SELECT a.ApplicationID, a.JobID, a.userID, a.ApplicationDate, a.CoverLetter, a.Notes, a.resumeID,a.Status,"
                + "r.fileResume, r.UploadDate,u.Name, u.Email, u.PhoneNumber, u.Address,"
                + "j.Education, j.Experience"
                + " FROM Application a"
                + " JOIN Resume r ON a.resumeID = r.resumeID"
                + " JOIN Jobseeker j ON a.userID = j.UserID"
                + " JOIN Users u ON j.UserID = u.UserID";

        return jdbcTemplate.query(sql, this::mapRow);
    }

    public FullApplication getbyID(int resumeID, int userID) {
        String sql = "SELECT a.ApplicationID, a.JobID, a.userID, a.ApplicationDate, a.CoverLetter, a.Notes, a.resumeID,a.Status,"
                + "r.fileResume, r.UploadDate,u.Name, u.Email, u.PhoneNumber, u.Address,"
                + "j.Education, j.Experience"
                + " FROM Application a"
                + " JOIN Resume r ON a.resumeID = r.resumeID"
                + " JOIN Jobseeker j ON a.userID = j.UserID"
                + " JOIN Users u ON j.UserID = u.UserID"
                + " WHERE r.UserID = ? AND r.resumeID = ?";
        List<FullApplication> f = jdbcTemplate.query(sql, this::mapRow, userID, resumeID);
        return f.isEmpty() ? null : f.get(0);
    }

    public void deleteByApplicationID(int ApplicationID) {
        // Xóa ở bảng Jobseeker trước (foreign key tới Users)
        String sql1 = "DELETE FROM Application WHERE ApplicationID = ?";
        jdbcTemplate.update(sql1, ApplicationID);

    }

    public List<FullApplication> search(String k) {
        String sql = "SELECT a.ApplicationID, a.JobID, a.userID, a.ApplicationDate, a.CoverLetter, a.Notes, a.resumeID,a.Status,"
                + "r.fileResume, r.UploadDate,u.Name, u.Email, u.PhoneNumber, u.Address,"
                + "j.Education, j.Experience"
                + " FROM Application a"
                + " JOIN Resume r ON a.resumeID = r.resumeID"
                + " JOIN Jobseeker j ON a.userID = j.UserID"
                + " JOIN Users u ON j.UserID = u.UserID"
                + " WHERE a.ApplicationID LIKE ?";
        String keywordLike = "%" + k + "%";
        return jdbcTemplate.query(sql, this::mapRow, keywordLike);
    }

    public List<FullApplication> getAppByID(int ID) {
        String sql = "SELECT a.ApplicationID, a.JobID, a.userID, a.ApplicationDate, a.CoverLetter, a.Notes, a.resumeID,a.Status,"
                + "r.fileResume, r.UploadDate,u.Name, u.Email, u.PhoneNumber, u.Address,"
                + "j.Education, j.Experience"
                + " FROM Application a"
                + " JOIN Resume r ON a.resumeID = r.resumeID"
                + " JOIN Jobseeker j ON a.userID = j.UserID"
                + " JOIN Users u ON j.UserID = u.UserID"
                + " WHERE a.JobID = ?";
        return jdbcTemplate.query(sql, this::mapRow, ID);
    }

    public int updateApplicationStatus(int applicationID, int status) {
        String sql = "UPDATE Application SET Status = ? WHERE ApplicationID = ?";
        return jdbcTemplate.update(sql, status, applicationID);
    }

}
