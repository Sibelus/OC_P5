package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsCommunityEmailAlertDTO;
import com.safetynet.api.service.CommunityEmailAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityEmailAlertController {

    private static final Logger logger = LogManager.getLogger(CommunityEmailAlertController.class);

    @Autowired
    private CommunityEmailAlertService communityEmailAlertService;

    @GetMapping("/communityEmail/{city}")
    public ListPersonsCommunityEmailAlertDTO phoneAlert(@PathVariable String city){
        logger.info("Request email for citizen of {}", city);
        ListPersonsCommunityEmailAlertDTO alert = communityEmailAlertService.getCommunityEmailAlert(city);
        logger.info("Return {}", alert);
        return alert;
    }
}
