package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

@Component
public class PersonPhoneAlertDTO {

    private String phone;


    @Override
    public String toString() {
        return "{" + "phone='" + phone + '\'' + '}';
    }


    //Getter & setter
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
