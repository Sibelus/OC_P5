package com.safetynet.api.model.DTO;

import java.util.ArrayList;

public class ListPersonsFirestationAlertDTO {

    private int children;
    private int adults;
    private ArrayList<PersonFirestationAlertDTO> persons;


    @Override
    public String toString() {
        return "{" +
                " children='" + children + '\'' +
                " adults='" + adults + '\'' +
                " persons='" + persons + '\'' +
                '}';
    }


    //Getters & setters
    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public ArrayList<PersonFirestationAlertDTO> getPersons(){
        return persons;
    }

    public void setPersons(ArrayList<PersonFirestationAlertDTO> persons){
        this.persons = persons;
    }
}
