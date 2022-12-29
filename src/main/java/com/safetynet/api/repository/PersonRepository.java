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
        //ArrayList that aggregate all data
        ArrayList<Person> personsAggregatedData = new ArrayList<>();

        ArrayList<Person> allPersons = getPersonsData();
        ArrayList<Firestation> allFirestations = getFirestationsData();
        ArrayList<Medicalrecord> allMedicalrecords = getMedicalrecordsData();


        for(Person person : allPersons) {
            //add firestation number
            for(Firestation firestation : allFirestations){
                if (person.getAddress().equals(firestation.getAddress())) {
                    person.setStation(firestation.getStation());
                }
            }
            //add medicalrecords
            for(Medicalrecord medicalrecord : allMedicalrecords){
                if(medicalrecord.getFirstName().equals(person.getFirstName()) && medicalrecord.getLastName().equals(person.getLastName())){
                    person.setBirthdate(medicalrecord.getBirthdate());
                    person.setMedications(medicalrecord.getMedications());
                    person.setAllergies(medicalrecord.getAllergies());
                }
            }
            personsAggregatedData.add(person);
        }
        return personsAggregatedData;
    }


    public ArrayList<Person> getPersonsData() {
        ArrayList<Person> allPersons = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Persons persons = null;

        try {
            persons = objectMapper.readValue(new File("src/main/resources/data.json"), Persons.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        allPersons.addAll(persons.getPersons());

        return allPersons;
    }


    public ArrayList<Firestation> getFirestationsData() {
        ArrayList<Firestation> allFirestations = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Firestations firestations = null;

        try {
            firestations = objectMapper.readValue(new File("src/main/resources/data.json"), Firestations.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        allFirestations.addAll(firestations.getFirestations());

        return allFirestations;
    }


    public ArrayList<Medicalrecord> getMedicalrecordsData() {
        ArrayList<Medicalrecord> allMedicalrecords = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Medicalrecords medicalrecords = null;

        try {
            medicalrecords = objectMapper.readValue(new File("src/main/resources/data.json"), Medicalrecords.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        allMedicalrecords.addAll(medicalrecords.getMedicalrecords());

        return allMedicalrecords;
    }
}
