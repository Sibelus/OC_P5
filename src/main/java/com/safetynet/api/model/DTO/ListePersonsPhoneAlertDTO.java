package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class ListePersonsPhoneAlertDTO {

    private ArrayList<PersonPhoneAlertDTO> phoneAlertList = new ArrayList<>();


    @Override
    public String toString() {
        return "{" + "phoneAlertList=" + phoneAlertList + '}';
    }


    //Getter & setter
    public ArrayList<PersonPhoneAlertDTO> getPhoneAlertList() {
        return phoneAlertList;
    }

    public void setPhoneAlertList(ArrayList<PersonPhoneAlertDTO> phoneAlertList) {
        this.phoneAlertList = phoneAlertList;
    }
}
