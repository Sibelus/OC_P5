package com.safetynet.api.controller;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.service.FirestationAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirestationAlertController {

    @Autowired
    private FirestationAlertService firestationAlertService;

    @GetMapping("/FirestationAlert/{firestationNumber}")
    public ListPersonsFirestationAlertDTO firestationAlert(@PathVariable int firestationNumber){
        return firestationAlertService.getFirestationAlert(firestationNumber);
    }
}
