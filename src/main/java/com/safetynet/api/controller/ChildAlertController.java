package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsChildAlertDTO;
import com.safetynet.api.service.ChildAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;

@RestController
public class ChildAlertController {

    private static final Logger logger = LogManager.getLogger(ChildAlertController.class);

    @Autowired
    ChildAlertService childAlertService;
    //private ArrayList<String> stringWithSpace;

    /*
    @GetMapping("/ChildAlert")
    public String childAlert(){
        logger.info("Request alert infos for children living at ");

        //URL url= new URL(stringWithSpace.replaceAll(" ","%20"));
        //ListPersonsChildAlertDTO alert = childAlertService.getChildAlert(address);
        logger.info("Return alert");
        return "alert";
    }*/


    @GetMapping("/ChildAlert/{address}")
    public ListPersonsChildAlertDTO childAlert(@PathVariable String address){
        logger.info("Request alert infos for children living at {}", address);

        //URL url= new URL(stringWithSpace.replaceAll(" ","%20"));
        ListPersonsChildAlertDTO alert = childAlertService.getChildAlert(address);
        logger.info("Return {}", alert);
        return alert;
    }
}
