package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsPersonInfoAlertDTO {
    ArrayList<PersonInfoAlertDTO> persons;


    @Override
    public String toString() {
        return "{ persons=" + persons + '}';
    }


    //Getter & setter
    public ArrayList<PersonInfoAlertDTO> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<PersonInfoAlertDTO> persons) {
        this.persons = persons;
    }
}
