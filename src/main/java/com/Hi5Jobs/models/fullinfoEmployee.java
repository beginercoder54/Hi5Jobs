/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

public class fullinfoEmployee {

    private int UserID;
    private int accountID;
    private String Username;
    private String Password;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private byte[] img;
    private String companyName;
    private String Taxcode;

    public fullinfoEmployee() {
    }

    public fullinfoEmployee(int UserID, int accountID, String Username, String Password, String Name, String Email, String PhoneNumber, String Address, byte[] img, String companyName, String Taxcode) {
        this.UserID = UserID;
        this.accountID = accountID;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.img = img;
        this.companyName = companyName;
        this.Taxcode = Taxcode;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxcode() {
        return Taxcode;
    }

    public void setTaxcode(String Taxcode) {
        this.Taxcode = Taxcode;
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

    public String getBase64Image() {
        if (img != null && img.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(img);
        }
        return "";
    }
}
