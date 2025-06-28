/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.services;

import com.Hi5Jobs.models.Alert;
import com.Hi5Jobs.repository.AlertRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    @Autowired
    private AlertRepo repo;

    public List<Alert> getAlertByUserID(int userID) {
        return repo.getAlertByUserID(userID);
    }

    public void addAlert(Alert alert) {
        repo.addAlert(alert);
    }

    public List<Alert> getAlertByID(int ID) {
        return repo.getAlertByUserID(ID);
    }
}
