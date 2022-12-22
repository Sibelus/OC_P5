package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsFireAlertDTO {
    private int firestationNumber;
    private ArrayList<PersonFireALertDTO> persons;


    @Override
    public String toString() {
        return "ListPersonsFireAlertDTO{" +
                "firestationNumber=" + firestationNumber +
                ", persons=" + persons +
                '}';
    }


    //Getters & setters
    public int getFirestationNumber() {
        return firestationNumber;
    }

    public void setFirestationNumber(int firestationNumber) {
        this.firestationNumber = firestationNumber;
    }

    public ArrayList<PersonFireALertDTO> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<PersonFireALertDTO> persons) {
        this.persons = persons;
    }
}
