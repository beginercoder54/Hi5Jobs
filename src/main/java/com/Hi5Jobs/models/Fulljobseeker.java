/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

/**
 *
 * @author hoang
 */
public class Fulljobseeker {

    private int UserID;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String education;
    private String experience;
    private int accountID;
    private String Username;
    private String Password;
    private int userType;
    private byte[] img;

    public Fulljobseeker() {
    }

    public Fulljobseeker(int UserID, String Name, String Email, String PhoneNumber, String Address, String education, String experience, int accountID, String Username, String Password, int userType, byte[] img) {
        this.UserID = UserID;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.education = education;
        this.experience = experience;
        this.accountID = accountID;
        this.Username = Username;
        this.Password = Password;
        this.userType = userType;
        this.img = img;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getBase64Image() {
        if (img != null && img.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(img);
        }
        return "";
    }

}
