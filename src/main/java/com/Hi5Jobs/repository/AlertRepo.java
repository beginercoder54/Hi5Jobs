/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Alert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlertRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Alert mapRow(ResultSet rs, int rowNum) throws SQLException {
        Alert alert = new Alert();
        alert.setAlertID(rs.getInt("alertID"));
        alert.setNameUser(rs.getString("nameuser"));
        alert.setMessage(rs.getString("message"));

        Timestamp timestamp = rs.getTimestamp("date");
        if (timestamp != null) {
            alert.setDate(timestamp.toLocalDateTime());
        }

        alert.setUserID(rs.getInt("UserID"));
        return alert;
    }

    public List<Alert> getAlertByUserID(int userID) {
        String sql = "SELECT * FROM alert WHERE userID = ? ORDER BY date DESC";
        return jdbcTemplate.query(sql, this::mapRow, userID);
    }

    public void addAlert(Alert alert) {
        String sql = "INSERT INTO alert (nameuser, message, date, UserID) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                alert.getNameUser(),
                alert.getMessage(),
                Timestamp.valueOf(alert.getDate()),
                alert.getUserID()
        );
    }
    public List<Alert> getAlertByID(int ID) {
    String sql = "SELECT * FROM alert WHERE UserID = ?";
        return jdbcTemplate.query(sql, this::mapRow, ID);
  
}
}
