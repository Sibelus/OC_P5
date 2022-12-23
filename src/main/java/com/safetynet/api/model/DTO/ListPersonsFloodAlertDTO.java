package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsFloodAlertDTO {
    private ArrayList<PersonFloodAlertDTO> persons;


    @Override
    public String toString() {
        return "{ persons=" + persons + '}';
    }

    //Getter & setter
    public ArrayList<PersonFloodAlertDTO> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<PersonFloodAlertDTO> persons) {
        this.persons = persons;
    }
}
