package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class PersonChildAlertDTO {

    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<PersonChildAlertDTO> otherFamilyMembers;


    @Override
    public String toString() {
        return "ChildAlertDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonChildAlertDTO that = (PersonChildAlertDTO) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
