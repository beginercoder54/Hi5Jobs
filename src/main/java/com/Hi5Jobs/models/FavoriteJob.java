/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.time.LocalDate;


public class FavoriteJob extends Job{
    private int FavoriteJobID;
    private int UserID;
    private int JobID;

    public FavoriteJob() {
    }

    public FavoriteJob(int FavoriteJobID) {
        this.FavoriteJobID = FavoriteJobID;
    }

    public FavoriteJob(int FavoriteJobID, int jobID, int UserID, String title, String DescriptionJob, String Location, String Salary, String requirement, String gentle, int numberofRecruiment, LocalDate uploadDate, int status, String Age, String salaryType) {
        super(jobID, UserID, title, DescriptionJob, Location, Salary, requirement, gentle, numberofRecruiment, uploadDate, status, Age, salaryType);
        this.FavoriteJobID = FavoriteJobID;
    }


    public int getFavoriteJobID() {
        return FavoriteJobID;
    }

    public void setFavoriteJobID(int FavoriteJobID) {
        this.FavoriteJobID = FavoriteJobID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int JobID) {
        this.JobID = JobID;
    }
    
    
    
}
