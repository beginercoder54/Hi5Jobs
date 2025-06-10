/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.awt.Image;
import java.time.LocalDateTime;

/**
 *
 * @author hoang
 */
public class Resume {
    private int resumeID;
    private Image imgResume;
    private LocalDateTime uploadDate;

    public Resume() {
    }

    public Resume(int resumeID, Image imgResume, LocalDateTime uploadDate) {
        this.resumeID = resumeID;
        this.imgResume = imgResume;
        this.uploadDate = uploadDate;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }

    public Image getImgResume() {
        return imgResume;
    }

    public void setImgResume(Image imgResume) {
        this.imgResume = imgResume;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }
    
}
