package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.service.IFirestationAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirestationAlertController {

    private static final Logger logger = LogManager.getLogger(FirestationAlertController.class);

    @Autowired
    IFirestationAlertService firestationAlertService;

    @GetMapping("/firestation/{firestationNumber}")
    public ListPersonsFirestationAlertDTO firestationAlert(@PathVariable int firestationNumber){
        logger.info("Request alert infos for firestation number {}", firestationNumber);
        ListPersonsFirestationAlertDTO alert = (ListPersonsFirestationAlertDTO) firestationAlertService.getAlert(firestationNumber);
        logger.info("Return {}", alert);
        return alert;
    }
}
