package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListPersonsCommunityEmailAlertDTO {
    ArrayList<PersonCommunityEmailDTO> communityEmailAlertList = new ArrayList<>();


    @Override
    public String toString() {
        return "{ communityEmailAlertList=" + communityEmailAlertList + '}';
    }


    //Getter & setter
    public ArrayList<PersonCommunityEmailDTO> getCommunityEmailAlertList() {
        return communityEmailAlertList;
    }

    public void setCommunityEmailAlertList(ArrayList<PersonCommunityEmailDTO> communityEmailAlertList) {
        this.communityEmailAlertList = communityEmailAlertList;
    }
}
