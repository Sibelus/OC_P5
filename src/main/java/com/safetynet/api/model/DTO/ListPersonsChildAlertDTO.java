package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsChildAlertDTO {

    private ArrayList<PersonChildAlertDTO> childrenAndTheirFamilly;


    @Override
    public String toString() {
        return "listChildAlertDTO{" +
                "childrenAndTheirFamilly=" + childrenAndTheirFamilly +
                '}';
    }


    //Getters & setters
    public ArrayList<PersonChildAlertDTO> getChildrenAndTheirFamilly() {
        return childrenAndTheirFamilly;
    }

    public void setChildrenAndTheirFamilly(ArrayList<PersonChildAlertDTO> childrenAndTheirFamilly) {
        this.childrenAndTheirFamilly = childrenAndTheirFamilly;
    }
}
