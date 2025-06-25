/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.time.LocalDate;

public class FullinfoJob {

    private int UserID;
    private int accountID;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private int jobID;
    private String title;
    private String DescriptionJob;
    private String Location;
    private String Salary;
    private String requirement;
    private String gentle;
    private int numberofRecruiment;
    private LocalDate uploadDate;
    private int status;
    private String Age;
    private String salaryType;
    private String companyDescription;
    private String companyName;
    private String Taxcode;
    private byte[] imgCompany;

    public FullinfoJob() {
    }

    public FullinfoJob(int UserID, int accountID, String Name, String Email, String PhoneNumber, String Address, int jobID, String title, String DescriptionJob, String Location, String Salary, String requirement, String gentle, int numberofRecruiment, LocalDate uploadDate, int status, String Age, String salaryType, String companyDescription, String companyName, String Taxcode, byte[] imgCompany) {
        this.UserID = UserID;
        this.accountID = accountID;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.jobID = jobID;
        this.title = title;
        this.DescriptionJob = DescriptionJob;
        this.Location = Location;
        this.Salary = Salary;
        this.requirement = requirement;
        this.gentle = gentle;
        this.numberofRecruiment = numberofRecruiment;
        this.uploadDate = uploadDate;
        this.status = status;
        this.Age = Age;
        this.salaryType = salaryType;
        this.companyDescription = companyDescription;
        this.companyName = companyName;
        this.Taxcode = Taxcode;
        this.imgCompany = imgCompany;
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


    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionJob() {
        return DescriptionJob;
    }

    public void setDescriptionJob(String DescriptionJob) {
        this.DescriptionJob = DescriptionJob;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getGentle() {
        return gentle;
    }

    public void setGentle(String gentle) {
        this.gentle = gentle;
    }

    public int getNumberofRecruiment() {
        return numberofRecruiment;
    }

    public void setNumberofRecruiment(int numberofRecruiment) {
        this.numberofRecruiment = numberofRecruiment;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
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

    public byte[] getImgCompany() {
        return imgCompany;
    }

    public void setImgCompany(byte[] imgCompany) {
        this.imgCompany = imgCompany;
    }
   

     public String getBase64Image() {
        if (imgCompany != null && imgCompany.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(imgCompany);
        }
        return "";
    }

}
