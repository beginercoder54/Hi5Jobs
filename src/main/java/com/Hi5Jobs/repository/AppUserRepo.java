/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Application;
import com.Hi5Jobs.models.ApplicatiowithUsername;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public class ApplicationMapper implements RowMapper<ApplicatiowithUsername> {

        @Override
        public ApplicatiowithUsername mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApplicatiowithUsername app = new ApplicatiowithUsername();
            app.setApplicationID(rs.getInt("ApplicationID"));
            app.setResumeID(rs.getInt("resumeID"));
            app.setJobID(rs.getInt("JobID"));
            app.setUserID(rs.getInt("userID"));

            Timestamp ts = rs.getTimestamp("ApplicationDate");
            if (ts != null) {
                app.setAppDate(ts.toLocalDateTime());
            }

            app.setStatus(rs.getInt("Status"));
            app.setCoverletter(rs.getString("CoverLetter"));
            app.setNotes(rs.getString("Notes"));

            // Thêm lấy tên người dùng (nếu SELECT có chứa Name)
            app.setName(rs.getString("Name"));

            return app;
        }
    }

    public List<ApplicatiowithUsername> getAllWithUserDetails(int jobID) {
        String sql = "SELECT a.*, u.Name "
                + "FROM Application a "
                + "JOIN Users u ON a.UserID = u.UserID "
                + "JOIN JobSeeker js ON u.UserID = js.UserID"
                + "WHERE a.ApplicationID = ?";
        return jdbcTemplate.query(sql, new ApplicationMapper(),jobID);
    }

}
