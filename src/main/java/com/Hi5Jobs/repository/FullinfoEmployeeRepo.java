/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.fullinfoEmployee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FullinfoEmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public fullinfoEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
        fullinfoEmployee emp = new fullinfoEmployee();
        emp.setUserID(rs.getInt("UserID"));
        emp.setAccountID(rs.getInt("accountID"));
        emp.setUsername(rs.getString("username"));
        emp.setPassword(rs.getString("password"));
        emp.setName(rs.getString("Name"));
        emp.setEmail(rs.getString("Email"));
        emp.setPhoneNumber(rs.getString("PhoneNumber"));
        emp.setAddress(rs.getString("Address"));
        emp.setImg(rs.getBytes("Image")); // Tên cột hình ảnh là 'Image'
        emp.setCompanyName(rs.getString("Companyname"));
        emp.setTaxcode(rs.getString("TaxCode"));
        return emp;
    }

    public fullinfoEmployee getByID(int userID) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address, u.Image,a.username, a.password,"
                + "e.CompanyName, e.TaxCode"
                + " FROM Users u"
                + " JOIN Employer e ON u.UserID = e.UserID"
                + " JOIN Account a ON u.accountID = a.accountID"
                + " WHERE u.UserID = ?";
        List<fullinfoEmployee> f = jdbcTemplate.query(sql, this::mapRow, userID);
        return f.isEmpty() ? null : f.get(0);
    }

    public List<fullinfoEmployee> getAll() {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address, u.Image,a.username, a.password,"
                + "e.CompanyName, e.TaxCode"
                + " FROM Users u"
                + " JOIN Employer e ON u.UserID = e.UserID"
                + " JOIN Account a ON u.accountID = a.accountID";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public void deleteByUserID(int userID, int accountID) {
        String sql4 = "DELETE FROM Job WHERE UserID = ?";
        jdbcTemplate.update(sql4, userID);
// Xóa ở bảng Jobseeker trước (foreign key tới Users)
        String sql1 = "DELETE FROM Employer WHERE UserID = ?";
        jdbcTemplate.update(sql1, userID);

        // Xóa ở bảng Users
        String sql2 = "DELETE FROM Users WHERE UserID = ?";
        jdbcTemplate.update(sql2, userID);

        // Nếu muốn, có thể xóa luôn cả Account nếu không dùng nữa:
        // (ví dụ lấy AccountID từ userID trước khi xóa Users)
        String sql3 = "DELETE FROM Account WHERE accountID = ?";
        jdbcTemplate.update(sql3, accountID);

    }

    public List<fullinfoEmployee> searchByKeyword(String keyword) {
        String sql = "SELECT u.UserID, u.accountID, u.Name, u.Email, u.PhoneNumber, u.Address, u.Image,a.username, a.password,"
                + "e.CompanyName, e.TaxCode"
                + " FROM Users u"
                + " JOIN Employer e ON u.UserID = e.UserID"
                + " JOIN Account a ON u.accountID = a.accountID"
                + " WHERE u.Name LIKE ? OR u.Email LIKE ? OR a.Username LIKE ? OR u.UserID LIKE ? OR u.PhoneNumber LIKE ? OR e.CompanyName LIKE ? OR e.TaxCode LIKE ?";

        String likeKeyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, this::mapRow, likeKeyword, likeKeyword, likeKeyword, likeKeyword, likeKeyword, likeKeyword, likeKeyword);
    }

}
