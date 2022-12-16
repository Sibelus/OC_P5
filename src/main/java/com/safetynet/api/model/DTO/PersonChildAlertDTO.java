package com.safetynet.api.model.DTO;

import com.safetynet.api.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonChildAlertDTO {

    private String firstname;
    private String lastname;
    private int age;
    private ArrayList<PersonChildAlertDTO> otherFamillyMembers;


    @Override
    public String toString() {
        return "ChildAlertDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", famillyMembers=" + otherFamillyMembers +
                '}';
    }


    //Getters & setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<PersonChildAlertDTO> getOtherFamillyMembers() {
        return otherFamillyMembers;
    }

    public void setOtherFamillyMembers(ArrayList<PersonChildAlertDTO> famillyMembers) {
        this.otherFamillyMembers = famillyMembers;
    }
}
