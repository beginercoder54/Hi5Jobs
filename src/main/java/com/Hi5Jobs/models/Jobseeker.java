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
    private String  education;
    private String experience;

    public Jobseeker() {
    }

    public Jobseeker(String education, String experience) {
        this.education = education;
        this.experience = experience;
    }

    public Jobseeker(String education, String experience, int UserID, int accountID, String Name, String Email, String PhoneNumber, String Address, byte[] img) {
        super(UserID, accountID, Name, Email, PhoneNumber, Address, img);
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
    
}
