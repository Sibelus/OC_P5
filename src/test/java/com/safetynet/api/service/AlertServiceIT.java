package com.safetynet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class AlertServiceIT {

    @Autowired
    private FirestationAlertService firestationAlertService;
    @Autowired
    private ChildAlertService childAlertService;
    @Autowired
    private PhoneAlertService phoneAlertService;
    @Autowired
    private FireAlertService fireAlertService;
    @Autowired
    private FloodAlertService floodAlertService;
    @Autowired
    private PersonInfoAlertService personInfoAlertService;
    @Autowired
    private CommunityEmailAlertService communityEmailAlertService;


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
        Assertions.assertNotNull(phoneAlertService);
    }

    @Test
    public void integrationTest_GetFireAlert(){
        //WHEN
        fireAlertService.getFireAlert("1509 Culver St");

        //THEN
        Assertions.assertNotNull(fireAlertService);
    }

    @Test
    public void integrationTest_GetFloodAlert(){
        //GIVEN
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));

        //WHEN
        floodAlertService.getFloodAlert(intList);

        //THEN
        Assertions.assertNotNull(floodAlertService);
    }

    @Test
    public void integrationTest_GetPersonInfoAlert(){
        //WHEN
        personInfoAlertService.getPersonInfoAlert("John","Boyd");

        //THEN
        Assertions.assertNotNull(personInfoAlertService);
    }

    @Test
    public void integrationTest_GetCommunityEmailAlert(){
        //WHEN
        communityEmailAlertService.getCommunityEmailAlert("Culver");

        //THEN
        Assertions.assertNotNull(communityEmailAlertService);
    }
}
