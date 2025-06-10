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
public class Job {
    private int jobID;
    private String title;
    private String DescriptionJob;
    private String Location;
    private double Salary;
    private String requirement;
    private int gentle;
    private int numberofRecruiment;
    private LocalDateTime uploadDate;
    private int status;

    public Job() {
    }

    public Job(int jobID, String title, String DescriptionJob, String Location, double Salary, String requirement, int gentle, int numberofRecruiment, LocalDateTime uploadDate, int status) {
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

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getGentle() {
        return gentle;
    }

    public void setGentle(int gentle) {
        this.gentle = gentle;
    }

    public int getNumberofRecruiment() {
        return numberofRecruiment;
    }

    public void setNumberofRecruiment(int numberofRecruiment) {
        this.numberofRecruiment = numberofRecruiment;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
