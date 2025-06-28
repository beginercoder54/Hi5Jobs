/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;


public class Report {
    private int TotalJ;
    private int TotalE;
    private int TotalJob;
    private int Application;
    private int job;
    private int resume;

    public Report() {
    }

    public Report(int TotalJ, int TotalE, int TotalJob, int Application, int job, int resume) {
        this.TotalJ = TotalJ;
        this.TotalE = TotalE;
        this.TotalJob = TotalJob;
        this.Application = Application;
        this.job = job;
        this.resume = resume;
    }

    public int getTotalJ() {
        return TotalJ;
    }

    public void setTotalJ(int TotalJ) {
        this.TotalJ = TotalJ;
    }

    public int getTotalE() {
        return TotalE;
    }

    public void setTotalE(int TotalE) {
        this.TotalE = TotalE;
    }

    public int getTotalJob() {
        return TotalJob;
    }

    public void setTotalJob(int TotalJob) {
        this.TotalJob = TotalJob;
    }

    public int getApplication() {
        return Application;
    }

    public void setApplication(int Application) {
        this.Application = Application;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getResume() {
        return resume;
    }

    public void setResume(int resume) {
        this.resume = resume;
    }
    
    
}
