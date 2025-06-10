/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

/**
 *
 * @author hoang
 */
public class Account {
    private int accountID;
    private String Username;
    private String Password;
    private int userType;

    public Account() {
    }

    public Account(int accountID, String Username, String Password, int userType) {
        this.accountID = accountID;
        this.Username = Username;
        this.Password = Password;
        this.userType = userType;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

  
    
}
