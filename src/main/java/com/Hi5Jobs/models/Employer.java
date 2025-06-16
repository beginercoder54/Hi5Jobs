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
public class Employer extends User {

    private int UserID;
    private String companyDescription;
    private String Taxcode;

    public Employer() {
    }

    public Employer(int UserID, String companyDescription, String Taxcode) {
        this.UserID = UserID;
        this.companyDescription = companyDescription;
        this.Taxcode = Taxcode;
    }

    public Employer(int userID, String companyDescription, String taxcode,
            int accountID, String name, String email, String phoneNumber, String address, byte[] img) {
        super(userID, accountID, name, email, phoneNumber, address, img);
        this.companyDescription = companyDescription;
        this.Taxcode = taxcode;
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
        return UserID;
    }

    @Override
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

}
