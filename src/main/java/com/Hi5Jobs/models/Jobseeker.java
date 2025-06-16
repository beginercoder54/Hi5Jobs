/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.awt.Image;

/**
 *
 * @author hoang
 */
public class Jobseeker extends User{
    private int UserID;
    private String  education;
    private String experience;

    public Jobseeker() {
    }

    public Jobseeker(int UserID, String education, String experience) {
        this.UserID = UserID;
        this.education = education;
        this.experience = experience;
    }

    public Jobseeker(int userID, String education, String experience, int UserID, int accountID, String Name, String Email, String PhoneNumber, String Address, byte[] img) {
        super(UserID, accountID, Name, Email, PhoneNumber, Address, img);
        this.UserID = userID;
        this.education = education;
        this.experience = experience;
    }



    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    
}
