/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.time.LocalDateTime;

public class FullApplication {

    private int resumeID;
    private int jobID;
    private int userID;
    private int ApplicationID;
    private LocalDateTime AppDate;
    private int status;
    private String Coverletter;
    private String Notes;
    private byte[] imgResume;
    private LocalDateTime uploadDate;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private String education;
    private String experience;

    public FullApplication() {
    }

    public FullApplication(int resumeID, int jobID, int userID, int ApplicationID, LocalDateTime AppDate, int status, String Coverletter, String Notes, byte[] imgResume, LocalDateTime uploadDate, String Name, String Email, String PhoneNumber, String Address, String education, String experience) {
        this.resumeID = resumeID;
        this.jobID = jobID;
        this.userID = userID;
        this.ApplicationID = ApplicationID;
        this.AppDate = AppDate;
        this.status = status;
        this.Coverletter = Coverletter;
        this.Notes = Notes;
        this.imgResume = imgResume;
        this.uploadDate = uploadDate;
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.education = education;
        this.experience = experience;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(int ApplicationID) {
        this.ApplicationID = ApplicationID;
    }

    public LocalDateTime getAppDate() {
        return AppDate;
    }

    public void setAppDate(LocalDateTime AppDate) {
        this.AppDate = AppDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCoverletter() {
        return Coverletter;
    }

    public void setCoverletter(String Coverletter) {
        this.Coverletter = Coverletter;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public byte[] getImgResume() {
        return imgResume;
    }

    public void setImgResume(byte[] imgResume) {
        this.imgResume = imgResume;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
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

    public String getBase64Image() {
        if (imgResume != null && imgResume.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(imgResume);
        }
        return "";
    }
}
