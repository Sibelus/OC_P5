package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsChildAlertDTO {

    private ArrayList<PersonChildAlertDTO> childrenAndTheirFamily;


    @Override
    public String toString() {
        return "{" + "childrenAndTheirFamily=" + childrenAndTheirFamily + '}';
    }


    //Getters & setters
    public ArrayList<PersonChildAlertDTO> getChildrenAndTheirFamily() {
        return childrenAndTheirFamily;
    }

    public void setChildrenAndTheirFamily(ArrayList<PersonChildAlertDTO> childrenAndTheirFamily) {
        this.childrenAndTheirFamily = childrenAndTheirFamily;
    }
}
