/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;


public class Employer extends User {

    private int userID;
    private String companyDescription;
    private String companyName;
    private String Taxcode;
    private byte[] imgCompany;

    public Employer() {
    }

    public Employer(int userID, String companyDescription, String companyName, String Taxcode, byte[] imgCompany) {
        this.userID = userID;
        this.companyDescription = companyDescription;
        this.companyName = companyName;
        this.Taxcode = Taxcode;
        this.imgCompany = imgCompany;
    }

    public Employer(int userID, String companyDescription, String companyName, String Taxcode, byte[] imgCompany, int UserID, int accountID, String Name, String Email, String PhoneNumber, String Address, byte[] img) {
        super(UserID, accountID, Name, Email, PhoneNumber, Address, img);
        this.userID = userID;
        this.companyDescription = companyDescription;
        this.companyName = companyName;
        this.Taxcode = Taxcode;
        this.imgCompany = imgCompany;
    }

   

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getTaxcode() {
        return Taxcode;
    }

    public void setTaxcode(String Taxcode) {
        this.Taxcode = Taxcode;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setUserID(int UserID) {
        this.userID = UserID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public byte[] getImgCompany() {
        return imgCompany;
    }

    public void setImgCompany(byte[] imgCompany) {
        this.imgCompany = imgCompany;
    }
    @Override
     public String getBase64Image() {
        if (imgCompany != null && imgCompany.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(imgCompany);
        }
        return "";
    }

}
