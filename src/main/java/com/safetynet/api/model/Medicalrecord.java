package com.safetynet.api.model;

public class Medicalrecord {

    private String firstName;
    private String lastName;
    private String birthdate;
    private String[] medications;
    private String[] allergies;

    //Getters & setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "Medicalrecord{" +
                " fistname='" + firstName + '\'' +
                " lastname='" + lastName + '\'' +
                " birthdate='" + birthdate + '\'' +
                " medaications='" + medications + '\'' +
                " allergies='" + allergies + '\'' +
                '}';
    }
}