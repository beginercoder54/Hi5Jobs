/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Resume;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Resume resume = new Resume();
        resume.setUserID(rs.getInt("UserID"));
        resume.setResumeID(rs.getInt("ResumeID"));
        resume.setImgResume(rs.getBytes("fileResume")); // giữ nguyên là byte[]

        Timestamp timestamp = rs.getTimestamp("uploadDate");
        if (timestamp != null) {
            resume.setUploadDate(timestamp.toLocalDateTime());
        }

        return resume;
    }

    public List<Resume> getListByUserID(int userID) {
        String sql = "SELECT * FROM Resume WHERE UserID = ?";
        return jdbcTemplate.query(sql, this::mapRow, userID); // ✅ trả đúng List<Resume>
    }

    public void save(Resume resume) {
        String sql = "INSERT INTO Resume (UserID, uploadDate, fileResume) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                resume.getUserID(),
                Timestamp.valueOf(resume.getUploadDate()),
                resume.getImgResume() // dạng byte[]
        );
    }

    public Resume getResumeById(int resumeID) {
        String sql = "SELECT * FROM Resume WHERE ResumeID = ?";
        List<Resume> employers = jdbcTemplate.query(sql, this::mapRow, resumeID);
        return employers.isEmpty() ? null : employers.get(0);
    }

    public List<Resume> getAll() {
        String sql = "SELECT * FROM Resume";
        return jdbcTemplate.query(sql, this::mapRow); // ✅ trả đúng List<Resume>
    }
    public List<Resume> search(String keyword) {
        String sql = "SELECT * FROM Resume WHERE resumeID LIKE ? OR UserID LIKE ?";
        String keywordLike = "%" + keyword + "%";
        return jdbcTemplate.query(sql, this::mapRow,keywordLike,keywordLike); // ✅ trả đúng List<Resume>
    }

}
