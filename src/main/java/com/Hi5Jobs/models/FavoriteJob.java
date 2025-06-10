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
public class FavoriteJob extends Job{
    private int FavoriteJobID;

    public FavoriteJob() {
    }

    public FavoriteJob(int FavoriteJobID) {
        this.FavoriteJobID = FavoriteJobID;
    }

    public FavoriteJob(int FavoriteJobID, int jobID, String title, String DescriptionJob, String Location, double Salary, String requirement, int gentle, int numberofRecruiment, LocalDateTime uploadDate, int status) {
        super(jobID, title, DescriptionJob, Location, Salary, requirement, gentle, numberofRecruiment, uploadDate, status);
        this.FavoriteJobID = FavoriteJobID;
    }

    public int getFavoriteJobID() {
        return FavoriteJobID;
    }

    public void setFavoriteJobID(int FavoriteJobID) {
        this.FavoriteJobID = FavoriteJobID;
    }
    
}
