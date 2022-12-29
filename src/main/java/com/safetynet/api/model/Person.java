package com.safetynet.api.model;


import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private String phone;
    private String email;
    private int station;
    private String birthdate;
    private String[] medications;
    private String[] allergies;


    @Override
    public String toString() {
        return "Person{" +
                " fistname='" + firstName + '\'' +
                " lastname='" + lastName + '\'' +
                " adress='" + address + '\'' +
                " city='" + city + '\'' +
                " zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +

                " station='" + station + '\'' +

                " birthdate='" + birthdate + '\'' +
                " medaications='" + medications + '\'' +
                " allergies='" + allergies + '\'' +
                '}';
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStation() {
        return station;
    }
    public void setStation(int station) {
        this.station = station;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
