package com.safetynet.api.model.DTO;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

@Component
public class PersonFloodAlertDTO {
    private String lastName;
    private String address;
    private String phone;
    private int age;
    private String[] medications;
    private String[] allergies;


    @Override
    public String toString() {
        return "PersonFloodAlertDTO{" +
                "lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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


    public static Comparator<PersonFloodAlertDTO> ComparatorAddress = new Comparator<PersonFloodAlertDTO>() {

        @Override
        public int compare(PersonFloodAlertDTO p1, PersonFloodAlertDTO p2) {
            return p1.getAddress().compareTo(p2.getAddress());
        }
    };
}
