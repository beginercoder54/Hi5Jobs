/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.models;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 *
 * @author hoang
 */
public class Resume {

    private int UserID;
    private int resumeID;
    private byte[] imgResume;
    private LocalDateTime uploadDate;

    public Resume() {
    }

    public Resume(int UserID, int resumeID, byte[] imgResume, LocalDateTime uploadDate) {
        this.UserID = UserID;
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

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getBase64Image() {
        if (imgResume != null && imgResume.length > 0) {
            return java.util.Base64.getEncoder().encodeToString(imgResume);
        }
        return "";
    }

}
