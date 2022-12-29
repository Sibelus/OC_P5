package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListePersonsPhoneAlertDTO;
import com.safetynet.api.service.IAlertService;
import com.safetynet.api.service.PhoneAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneAlertController {

    private static final Logger logger = LogManager.getLogger(PhoneAlertController.class);

    @Autowired
    @Qualifier(value = "phoneAlert")
    IAlertService phoneAlertService;

    @GetMapping("/phoneAlert/{firestationNumber}")
    public ListePersonsPhoneAlertDTO phoneAlert(@PathVariable int firestationNumber){
        logger.info("Request phone numbers for firestation number {}", firestationNumber);
        ListePersonsPhoneAlertDTO alert = (ListePersonsPhoneAlertDTO) phoneAlertService.getAlert(firestationNumber);
        logger.info("Return {}", alert);
        return alert;
    }
}
