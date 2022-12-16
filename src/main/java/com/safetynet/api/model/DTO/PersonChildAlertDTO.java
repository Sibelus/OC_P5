package com.safetynet.api.model.DTO;

import com.safetynet.api.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonChildAlertDTO {

    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<PersonChildAlertDTO> otherFamilyMembers;


    @Override
    public String toString() {
        return "ChildAlertDTO{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                ", familyMembers=" + otherFamilyMembers +
                '}';
    }


    //Getters & setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<PersonChildAlertDTO> getOtherFamillyMembers() {
        return otherFamilyMembers;
    }

    public void setOtherFamillyMembers(ArrayList<PersonChildAlertDTO> famillyMembers) {
        this.otherFamilyMembers = famillyMembers;
    }
}
