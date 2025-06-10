/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.time.LocalDateTime;

/**
 *
 * @author hoang
 */
public class Alert {
    private int alertID;
    private String nameUser;
    private String message;
    private LocalDateTime date;

    public Alert() {
    }

    public Alert(int alertID, String nameUser, String message, LocalDateTime date) {
        this.alertID = alertID;
        this.nameUser = nameUser;
        this.message = message;
        this.date = date;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
}
