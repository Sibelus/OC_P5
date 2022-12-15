package com.safetynet.api.service;

import com.safetynet.api.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirestationAlertSeviceIT {
    @Autowired
    PersonRepository personRepository;

    /*
    @Test
    public void integrationTest_GetFirestationAlert(){

        //GIVEN
        FirestationAlertService firestationAlertService = new FirestationAlertService();

        //WHEN
        firestationAlertService.getFirestationAlert(1);

        //THEN
        Assertions.assertNotNull(firestationAlertService);
    }*/
}
