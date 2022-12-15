package com.safetynet.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.model.*;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;




@Repository
public class PersonRepository {

    public ArrayList<Person> getPersonsAggregatedData() {


        ObjectMapper objectMapper = new ObjectMapper();
        Persons persons;
        //ArrayList that aggregate all data
        ArrayList<Person> personsAggregatedData = new ArrayList<>();

        {
            try {
                persons = objectMapper.readValue(new File("src/main/resources/data.json"), Persons.class);
                Firestations firestations = objectMapper.readValue(new File("src/main/resources/data.json"), Firestations.class);
                Medicalrecords medicalrecords = objectMapper.readValue(new File("src/main/resources/data.json"), Medicalrecords.class);

                for(Person citizen : persons.getPersons()) {
                    //add firestation number
                    for(Firestation firestation : firestations.getFirestations()){
                        if (citizen.getAddress().equals(firestation.getAddress())) {
                            citizen.setStation(firestation.getStation());
                        }
                    }

                    //add medicalrecords
                    for(Medicalrecord medicalrecord : medicalrecords.getMedicalrecords()){
                        if(medicalrecord.getFirstName().equals(citizen.getFirstName()) && medicalrecord.getLastName().equals(citizen.getLastName())){
                            citizen.setBirthdate(medicalrecord.getBirthdate());
                            citizen.setMedications(medicalrecord.getMedications());
                            citizen.setAllergies(medicalrecord.getAllergies());
                        }
                    }
                    personsAggregatedData.add(citizen);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return personsAggregatedData;
    }

}
