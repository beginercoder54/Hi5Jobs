/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Fulljobseeker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FulljobseekerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Fulljobseeker mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fulljobseeker jobseeker = new Fulljobseeker();
        jobseeker.setUserID(rs.getInt("UserID"));
        jobseeker.setName(rs.getString("Name"));
        jobseeker.setEmail(rs.getString("Email"));
        jobseeker.setPhoneNumber(rs.getString("PhoneNumber"));
        jobseeker.setAddress(rs.getString("Address"));
        jobseeker.setEducation(rs.getString("Education"));
        jobseeker.setExperience(rs.getString("Experience"));
        jobseeker.setAccountID(rs.getInt("accountID"));
        jobseeker.setUsername(rs.getString("username"));
        jobseeker.setPassword(rs.getString("password"));
        jobseeker.setUserType(rs.getInt("userType"));
        jobseeker.setImg(rs.getBytes("Image"));
        return jobseeker;
    }

    public Fulljobseeker getByUserID(int userID) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.Address, u.PhoneNumber, u.Image,"
                + "a.username, a.password, a.userType,"
                + "j.Education, j.Experience"
                + " FROM Users u"
                + " JOIN Account a ON u.accountID = a.accountID"
                + " JOIN Jobseeker j ON u.UserID = j.UserID"
                + " WHERE u.UserID =?    ";
        List<Fulljobseeker> f = jdbcTemplate.query(sql, this::mapRow, userID);
        return f.isEmpty() ? null : f.get(0);
    }

    public List<Fulljobseeker> getAll() {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.Address, u.PhoneNumber, u.Image,"
                + "a.username, a.password, a.userType,"
                + "j.Education, j.Experience"
                + " FROM Users u"
                + " JOIN Account a ON u.accountID = a.accountID"
                + " JOIN Jobseeker j ON u.UserID = j.UserID"; // hoặc tên bảng phù hợp trong CSDL
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public void deleteByUserID(int userID, int accountID) {
        // Xóa ở bảng Jobseeker trước (foreign key tới Users)
        String sql1 = "DELETE FROM Jobseeker WHERE UserID = ?";
        jdbcTemplate.update(sql1, userID);

        // Xóa ở bảng Users
        String sql2 = "DELETE FROM Users WHERE UserID = ?";
        jdbcTemplate.update(sql2, userID);

        // Nếu muốn, có thể xóa luôn cả Account nếu không dùng nữa:
        // (ví dụ lấy AccountID từ userID trước khi xóa Users)
        String sql3 = "DELETE FROM Account WHERE accountID = ?";
        jdbcTemplate.update(sql3, accountID);
        String sql4 = "DELETE FROM Application WHERE userID = ?";
        jdbcTemplate.update(sql4, userID);
        String sql5 = "DELETE FROM Resume WHERE UserID = ?";
        jdbcTemplate.update(sql5, userID);
        String sql6 = "DELETE FROM FavoriteJob WHERE UserID = ?";
        jdbcTemplate.update(sql6, userID);

    }

    public List<Fulljobseeker> searchByKeyword(String keyword) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address, u.Image,"
                + "j.Education, j.Experience,"
                + "a.Username, a.Password, a.UserType"
                + " FROM Users u"
                + " JOIN Jobseeker j ON u.UserID = j.UserID"
                + " JOIN Account a ON u.AccountID = a.AccountID"
                + " WHERE u.Name LIKE ? OR u.Email LIKE ? OR a.Username LIKE ? OR u.UserID LIKE ? OR u.PhoneNumber LIKE ?";

        String likeKeyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, this::mapRow, likeKeyword, likeKeyword,likeKeyword ,likeKeyword,likeKeyword);
    }

}
