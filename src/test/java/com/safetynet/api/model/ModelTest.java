package com.safetynet.api.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    @Test
    public void testPerson_SetAndGetAllInfos(){
        //GIVEN
        Person person = new Person();

        String firstName = "Lucy";
        String lastName = "Fair";
        String address = "666 Hell street";
        String city = "Babylon";
        int zip = 666;
        String phone = "666-666-666";
        String email = "lfair@fallen.com";
        int station = 666;
        String birthdate = "01/01/0001";
        String[] medications = {"sulfur", "fire"};
        String[] allergies = {"kitten", "generosity"};

        String personToString = "Person{" +
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

        //WHEN
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setZip(zip);
        person.setPhone(phone);
        person.setEmail(email);
        person.setStation(station);
        person.setBirthdate(birthdate);
        person.setMedications(medications);
        person.setAllergies(allergies);

        //THEN
        Assertions.assertEquals(person.getFirstName(), firstName);
        Assertions.assertEquals(person.getLastName(), lastName);
        Assertions.assertEquals(person.getAddress(), address);
        Assertions.assertEquals(person.getCity(), city);
        Assertions.assertEquals(person.getZip(), zip);
        Assertions.assertEquals(person.getPhone(), phone);
        Assertions.assertEquals(person.getEmail(), email);
        Assertions.assertEquals(person.getStation(), station);
        Assertions.assertEquals(person.getBirthdate(), birthdate);
        Assertions.assertEquals(person.getMedications(), medications);
        Assertions.assertEquals(person.getAllergies(), allergies);
        Assertions.assertEquals(person.toString(), personToString);
    }

    @Test
    public void testPersons_SetAndGetAllInfos(){
        //GIVEN
        Persons persons = new Persons();
        Person person1 = new Person();

        List<Person> allPersons = new ArrayList<Person>();
        allPersons.add(person1);

        //WHEN
        persons.setPersons(allPersons);

        //THEN
        Assertions.assertEquals(persons.getPersons(), allPersons);
    }

    @Test
    public void testFirestation_SetAndGetAllInfos(){
        //GIVEN
        Firestation firestation = new Firestation();
        String address = "Fire street";
        int station = 1;
        String firestationToString = "Firestation{" +
                " adress='" + address + '\'' +
                " station='" + station + '\'' +
                '}';

        //WHEN
        firestation.setAddress(address);
        firestation.setStation(station);

        //THEN
        Assertions.assertEquals(firestation.getAddress(), address);
        Assertions.assertEquals(firestation.getStation(), station);
        Assertions.assertEquals(firestation.toString(), firestationToString);
    }

    @Test
    public void testFirestations_SetAndG(){
        //GIVEN
        Firestations firestations = new Firestations();
        Firestation firestation = new Firestation();

        List<Firestation> allFirestations = new ArrayList<>();
        allFirestations.add(firestation);

        //WHEN
        firestations.setFirestations(allFirestations);

        //THEN
        Assertions.assertEquals(firestations.getFirestations(), allFirestations);
    }

    @Test
    public void testMedicalRecord_SetAndGetAllInfos(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        String firstName = "Natacha";
        String lastName = "Tertone";
        String birthdate = "04/12/1985";
        String[] medications = {"scotch","glue"};
        String[] allergies = {"pollen", "penicillin"};
        String medicalrecordToString = "Medicalrecord{" +
                " fistname='" + firstName + '\'' +
                " lastname='" + lastName + '\'' +
                " birthdate='" + birthdate + '\'' +
                " medaications='" + medications + '\'' +
                " allergies='" + allergies + '\'' +
                '}';

        //WHEN
        medicalrecord.setFirstName(firstName);
        medicalrecord.setLastName(lastName);
        medicalrecord.setBirthdate(birthdate);
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //THEN
        Assertions.assertEquals(medicalrecord.getFirstName(), firstName);
        Assertions.assertEquals(medicalrecord.getLastName(), lastName);
        Assertions.assertEquals(medicalrecord.getBirthdate(), birthdate);
        Assertions.assertEquals(medicalrecord.getMedications(), medications);
        Assertions.assertEquals(medicalrecord.getAllergies(), allergies);
        Assertions.assertEquals(medicalrecord.toString(), medicalrecordToString);
    }

    @Test
    public void testMedicalrecords_GetAndSetAllInfos(){
        //GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        Medicalrecord medicalrecord = new Medicalrecord();

        List<Medicalrecord> allMedicalrecords = new ArrayList<>();
        allMedicalrecords.add(medicalrecord);

        //WHEN
        medicalrecords.setMedicalrecords(allMedicalrecords);

        //THEN
        Assertions.assertEquals(medicalrecords.getMedicalrecords(), allMedicalrecords);
    }
}
