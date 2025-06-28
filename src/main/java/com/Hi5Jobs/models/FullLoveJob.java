/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.time.LocalDate;

/**
 *
 * @author hoang
 */
public class FullLoveJob {
    private int FavoriteJobID;
    private int UserID;
    private int JobID;
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

    public FullLoveJob() {
    }

    public FullLoveJob(int FavoriteJobID, int UserID, int JobID, String title, String DescriptionJob, String Location, String Salary, String requirement, String gentle, int numberofRecruiment, LocalDate uploadDate, int status, String Age, String salaryType) {
        this.FavoriteJobID = FavoriteJobID;
        this.UserID = UserID;
        this.JobID = JobID;
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
    
}
