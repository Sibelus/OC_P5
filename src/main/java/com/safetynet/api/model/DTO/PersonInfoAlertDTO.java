package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PersonInfoAlertDTO {
    private String lastName;
    private String address;
    private int age;
    private String email;
    private String[] medications;
    private String[] allergies;


    @Override
    public String toString() {
        return "PersonInfoAlertDTO{" +
                "lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", medications=" + Arrays.toString(medications) +
                ", allergies=" + Arrays.toString(allergies) +
                '}';
    }


    //Getters & setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getMedications() {
        return medications;
    }

    public void setMedications(String[] medications) {
        this.medications = medications;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }
}
