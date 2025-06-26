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
public class Application {
    private int resumeID;
    private int jobID;
    private int userID;
    private int ApplicationID;
    private LocalDateTime AppDate;
    private int status;
    private String Coverletter;
    private String Notes;

    public Application() {
    }

    public Application(int resumeID, int jobID, int userID, int ApplicationID, LocalDateTime AppDate, int status, String Coverletter, String Notes) {
        this.resumeID = resumeID;
        this.jobID = jobID;
        this.userID = userID;
        this.ApplicationID = ApplicationID;
        this.AppDate = AppDate;
        this.status = status;
        this.Coverletter = Coverletter;
        this.Notes = Notes;
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

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }
    
}
