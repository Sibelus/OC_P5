package com.safetynet.api.repository;

import com.safetynet.api.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;

@SpringBootTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testAggregateData() {
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();

        Assertions.assertEquals(3 , allPersons.get(0).getStation());
        Assertions.assertEquals("03/06/1984", allPersons.get(0).getBirthdate());
    }

    @Test
    public void testGetPersonData(){
        ArrayList<Person> allPersons = personRepository.getPersonsData();

        Assertions.assertEquals("John", allPersons.get(0).getFirstName());
    }

    @Test
    public void testGetFirestationData(){
        ArrayList<Firestation> allFirestations = personRepository.getFirestationsData();

        Assertions.assertEquals("1509 Culver St", allFirestations.get(0).getAddress());
    }

    @Test
    public void testGetMedicalrecordData(){
        ArrayList<Medicalrecord> allMedicalrecords = personRepository.getMedicalrecordsData();

        Assertions.assertEquals("03/06/1984", allMedicalrecords.get(0).getBirthdate());
    }
}
