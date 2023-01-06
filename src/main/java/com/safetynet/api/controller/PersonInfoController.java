package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsPersonInfoAlertDTO;
import com.safetynet.api.service.IPersonInfoAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfoController {

    private static final Logger logger = LogManager.getLogger(FloodAlertController.class);

    @Autowired
    IPersonInfoAlertService personInfoAlertService;

    @GetMapping("/personInfo/{firstName},{lastName}")
    public ListPersonsPersonInfoAlertDTO getPersonInfoAlert(@PathVariable String firstName, @PathVariable String lastName){
        logger.info("Request alert infos for {} {}", firstName, lastName);
        ListPersonsPersonInfoAlertDTO alert = (ListPersonsPersonInfoAlertDTO) personInfoAlertService.getAlert(firstName, lastName);
        logger.info("Return {}", alert);
        return alert;
    }
}
