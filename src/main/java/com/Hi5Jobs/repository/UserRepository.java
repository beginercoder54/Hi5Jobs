/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hoang
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("UserID"));
        user.setName(rs.getString("Name"));
        user.setEmail(rs.getString("Email"));
        user.setPhoneNumber(rs.getString("PhoneNumber"));
        user.setAddress(rs.getString("Address"));
        user.setImg(rs.getBytes("Image"));
        return user;
    }
    
    public int checkPhoneNumber(String Phone){
        String sql="SELECT PhoneNumber FROM User WHERE PhoneNumbers=?";
        List<User> accounts = jdbcTemplate.query(sql, this::mapRow, Phone);
        if(accounts.isEmpty()){
            return 0;
        }
        return 1;
    }
}
