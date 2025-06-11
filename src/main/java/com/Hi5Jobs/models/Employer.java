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
public class Employer extends User{
    private String companyDescription;
    private String Taxcode;

    public Employer() {
    }

    public Employer(String companyDescription, String Taxcode) {
        this.companyDescription = companyDescription;
        this.Taxcode = Taxcode;
    }

    public Employer(String companyDescription, String Taxcode, int UserID, String Name, String Email, String PhoneNumber, String Address, byte[] img) {
        super(UserID, Name, Email, PhoneNumber, Address, img);
        this.companyDescription = companyDescription;
        this.Taxcode = Taxcode;
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
    
}
