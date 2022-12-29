package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsChildAlertDTO;
import com.safetynet.api.service.ChildAlertService;
import com.safetynet.api.service.IAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;

@RestController
public class ChildAlertController {

    private static final Logger logger = LogManager.getLogger(ChildAlertController.class);

    @Autowired
    @Qualifier(value = "childAlert")
    IAlertService childAlertService;

    @GetMapping("/childAlert/{address}")
    public ListPersonsChildAlertDTO childAlert(@PathVariable String address){
        logger.info("Request alert infos for children living at {}", address);
        ListPersonsChildAlertDTO alert = (ListPersonsChildAlertDTO) childAlertService.getAlert(address);
        logger.info("Return {}", alert);
        return alert;
    }
}
