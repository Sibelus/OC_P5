package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.model.DTO.ListPersonsFloodAlertDTO;
import com.safetynet.api.service.FloodAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodAlertController {

    private static final Logger logger = LogManager.getLogger(FloodAlertController.class);

    @Autowired
    FloodAlertService floodAlertService;

    @GetMapping("/flood/stations/{listFirestationNumber}")
    public ListPersonsFloodAlertDTO getFloodAlert(@PathVariable List<Integer> listFirestationNumber){
        logger.info("Request alert infos for firestation number {}", listFirestationNumber);
        ListPersonsFloodAlertDTO alert = floodAlertService.getFloodAlert(listFirestationNumber);
        logger.info("Return {}", alert);
        return alert;
    }
}
