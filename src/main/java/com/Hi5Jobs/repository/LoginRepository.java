/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.Account;
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
public class LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException{
        Account account= new Account();
        account.setAccountID(rs.getInt("accountID"));
        account.setUsername(rs.getString("username"));
        account.setPassword(rs.getString("password"));
        account.setUserType(rs.getInt("userType"));
        return account;
    }
    
    public int ValidAccount(String username,String password){
        String sql="SELECT * FROM Account WHERE username=? and password= ?";
        List<Account> accounts = jdbcTemplate.query(sql, this::mapRow, username, password);
        if(accounts.isEmpty()){
            return 0;
        }
        return 1;
    }
}
