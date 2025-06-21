/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Account;
import com.Hi5Jobs.models.User;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hoang
 */
@Repository
public class RegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository repo;

    public int registerNew(Account account, User user) throws IOException {
        // Bước 1: Insert vào bảng Account và lấy accountID mới tạo
        String sqlAccount = "INSERT INTO Account (username, password) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            return ps;
        }, keyHolder);

        // Bước 2: Lấy accountID vừa được tạo
        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Tạo tài khoản thất bại: không lấy được accountID");
        }

        int accountID = key.intValue();

        byte[] defaultImageBytes = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/image/user.png")) {
            if (inputStream != null) {
                defaultImageBytes = inputStream.readAllBytes();
            }
        } catch (IOException e) {
            e.printStackTrace(); // log lỗi nếu có
        }

        // B3: Insert user
        String sqlUser = "INSERT INTO Users (accountID, Name, PhoneNumber, Image) VALUES (?, ?, ?, ?)";
        byte[] finalImage = defaultImageBytes; // để dùng trong lambda
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlUser);
            ps.setInt(1, accountID);
            ps.setString(2, user.getName());
            ps.setString(3, user.getPhoneNumber());
            ps.setBytes(4, finalImage); // dùng byte[] ảnh
            return ps;
        });
        return accountID;
    }

    public void updateUserType(int accountID, int userType) {
        User user = repo.findByAccountId(accountID);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy User tương ứng với accountID: " + accountID);
        }

        int userID = user.getUserID();
        if (userType == 2) {
            insertRole(userID);
        } else {
            insertRoleS(userID);
        }
        String sql = "UPDATE Account SET userType = ? WHERE accountID = ?";
        jdbcTemplate.update(sql, userType, accountID);

    }

    public void insertRole(int UserID) {
        String sqlEmployer = "INSERT INTO Employer (UserID) VALUES (?)";
        jdbcTemplate.update(sqlEmployer, UserID);
    }

    public void insertRoleS(int UserID) {
        String sqlJobSeeker = "INSERT INTO JobSeeker (UserID) VALUES (?)";
        jdbcTemplate.update(sqlJobSeeker, UserID);
    }

}
