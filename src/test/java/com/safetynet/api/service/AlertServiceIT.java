package com.safetynet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlertServiceIT {

    @Autowired
    private FirestationAlertService firestationAlertService;
    @Autowired
    private ChildAlertService childAlertService;
    @Autowired
    private PhoneAlertService phoneAlertService;


    @Test
    public void integrationTest_GetFirestationAlert(){
        //WHEN
        firestationAlertService.getFirestationAlert(1);

        //THEN
        Assertions.assertNotNull(firestationAlertService);
    }

    @Test
    public void integrationTest_GetChildAlert(){
        //WHEN
        childAlertService.getChildAlert("1509 Culver St");

        //THEN
        Assertions.assertNotNull(childAlertService);
    }

    @Test
    public void integrationTest_GetPhoneAlert(){
        //WHEN
        phoneAlertService.getPhoneAlert(1);

        //THEN
        Assertions.assertNotNull(childAlertService);
    }
}
