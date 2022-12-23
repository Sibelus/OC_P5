package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

@Component
public class PersonCommunityEmailDTO {
    private String email;


    @Override
    public String toString() {
        return "PersonCommunityEmailDTO{" +
                "email='" + email + '\'' +
                '}';
    }


    //Getter & setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
