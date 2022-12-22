package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsFireAlertDTO;
import com.safetynet.api.service.FireAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireAlertController {

    private static final Logger logger = LogManager.getLogger(FireAlertController.class);

    @Autowired
    private FireAlertService fireAlertService;

    @GetMapping("/fire/{address}")
    public ListPersonsFireAlertDTO firestationAlert(@PathVariable String address){
        logger.info("Request alert infos for this address : {}", address);
        ListPersonsFireAlertDTO alert = fireAlertService.getFireAlert(address);
        logger.info("Return {}", alert);
        return alert;
    }
}
