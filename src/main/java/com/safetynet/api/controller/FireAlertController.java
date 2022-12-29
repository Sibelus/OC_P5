package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsFireAlertDTO;
import com.safetynet.api.service.FireAlertService;
import com.safetynet.api.service.IAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireAlertController {

    private static final Logger logger = LogManager.getLogger(FireAlertController.class);

    @Autowired
    @Qualifier(value = "fireAlert")
    IAlertService fireAlertService;

    @GetMapping("/fire/{address}")
    public ListPersonsFireAlertDTO firestationAlert(@PathVariable String address){
        logger.info("Request alert infos for this address : {}", address);
        ListPersonsFireAlertDTO alert = (ListPersonsFireAlertDTO) fireAlertService.getAlert(address);
        logger.info("Return {}", alert);
        return alert;
    }
}
