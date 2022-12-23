package com.safetynet.api.model;

import com.safetynet.api.model.DTO.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ModelDTOTest {

    @Test
    public void testPersonFirestationDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonFirestationAlertDTO personFirestationAlertDTO = new PersonFirestationAlertDTO();
        String firstName = "Barak";
        String lastName = "Afritte";
        String address = "13 fish and chips street";
        String phone = "123- 456- 789";
        String personFirestationAlertDTOToString = "{" +
                " fistname='" + firstName + '\'' +
                " lastname='" + lastName + '\'' +
                " adress='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';

        //WHEN
        personFirestationAlertDTO.setFirstName(firstName);
        personFirestationAlertDTO.setLastName(lastName);
        personFirestationAlertDTO.setAddress(address);
        personFirestationAlertDTO.setPhone(phone);

        //THEN
        Assertions.assertEquals(personFirestationAlertDTO.getFirstName(), firstName);
        Assertions.assertEquals(personFirestationAlertDTO.getLastName(), lastName);
        Assertions.assertEquals(personFirestationAlertDTO.getAddress(), address);
        Assertions.assertEquals(personFirestationAlertDTO.getPhone(), phone);
        Assertions.assertEquals(personFirestationAlertDTO.toString(), personFirestationAlertDTOToString);
    }

    @Test
    public void testListPersonFirestationAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        ListPersonsFirestationAlertDTO listPersonsFirestationAlertDTO = new ListPersonsFirestationAlertDTO();
        ArrayList<PersonFirestationAlertDTO> persons = new ArrayList<>();
        PersonFirestationAlertDTO personFirestationAlertDTO = new PersonFirestationAlertDTO();
        persons.add(personFirestationAlertDTO);
        int children = 1;
        int adults = 1;

        String listPersonsFirestationAlertDTOToString = "{" +
                " children='" + children + '\'' +
                " adults='" + adults + '\'' +
                " persons='" + persons + '\'' +
                '}';

        //WHEN
        listPersonsFirestationAlertDTO.setChildren(children);
        listPersonsFirestationAlertDTO.setAdults(adults);
        listPersonsFirestationAlertDTO.setPersons(persons);

        //THEN
        Assertions.assertEquals(listPersonsFirestationAlertDTO.getChildren(), children);
        Assertions.assertEquals(listPersonsFirestationAlertDTO.getAdults(), adults);
        Assertions.assertEquals(listPersonsFirestationAlertDTO.getPersons(), persons);
        Assertions.assertEquals(listPersonsFirestationAlertDTO.toString(), listPersonsFirestationAlertDTOToString);
    }

    @Test
    public void testPersonChlidAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonChildAlertDTO personChildAlertDTO = new PersonChildAlertDTO();
        String firstName = "Hannah";
        String lastName = "Konda";
        int age = 18;
        ArrayList<PersonChildAlertDTO> otherFamilyMembers = new ArrayList<>();

        String personChildAlertDTOToString = "ChildAlertDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", familyMembers=" + otherFamilyMembers +
                '}';

        //WHEN
        personChildAlertDTO.setFirstName(firstName);
        personChildAlertDTO.setLastName(lastName);
        personChildAlertDTO.setAge(age);
        personChildAlertDTO.setOtherFamillyMembers(otherFamilyMembers);

        //THEN
        Assertions.assertEquals(personChildAlertDTO.getFirstName(), firstName);
        Assertions.assertEquals(personChildAlertDTO.getLastName(), lastName);
        Assertions.assertEquals(personChildAlertDTO.getAge(), age);
        Assertions.assertEquals(personChildAlertDTO.getOtherFamillyMembers(), otherFamilyMembers);
        Assertions.assertEquals(personChildAlertDTO.toString(), personChildAlertDTOToString);
    }

    @Test
    public void testListPersChildAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        ListPersonsChildAlertDTO listPersonsChildAlertDTO = new ListPersonsChildAlertDTO();
        ArrayList<PersonChildAlertDTO> childrenAndTheirFamily = new ArrayList<>();
        String listPersonChildAlertDTOToString = "{" + "childrenAndTheirFamily=" + childrenAndTheirFamily + '}';

        //WHEN
        listPersonsChildAlertDTO.setChildrenAndTheirFamily(childrenAndTheirFamily);

        //THEN
        Assertions.assertEquals(listPersonsChildAlertDTO.getChildrenAndTheirFamily(), childrenAndTheirFamily);
        Assertions.assertEquals(listPersonsChildAlertDTO.toString(), listPersonChildAlertDTOToString);
    }

    @Test
    public void testPersonPhoneAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonPhoneAlertDTO personPhoneAlertDTO = new PersonPhoneAlertDTO();
        String phone = ("123-456-789");
        String personPhoneLAlertDTOToString = "{" + "phone='" + phone + '\'' + '}';

        //WHEN
        personPhoneAlertDTO.setPhone(phone);

        //THEN
        Assertions.assertEquals(phone, personPhoneAlertDTO.getPhone());
        Assertions.assertEquals(personPhoneLAlertDTOToString, personPhoneAlertDTO.toString());
    }

    @Test
    public void testListPersonsPhoneAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        ListePersonsPhoneAlertDTO listePersonsPhoneAlertDTO = new ListePersonsPhoneAlertDTO();
        ArrayList<PersonPhoneAlertDTO> phoneAlertList = new ArrayList<>();
        String listPersonsPhoneAlertDTOToString = "{" + "phoneAlertList=" + phoneAlertList + '}';

        //WHEN
        listePersonsPhoneAlertDTO.setPhoneAlertList(phoneAlertList);

        //THEN
        Assertions.assertEquals(phoneAlertList, listePersonsPhoneAlertDTO.getPhoneAlertList());
        Assertions.assertEquals(listPersonsPhoneAlertDTOToString, listePersonsPhoneAlertDTO.toString());
    }

    @Test
    public void testPersonFireALertDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonFireALertDTO personFireALertDTO = new PersonFireALertDTO();
        String lastName = "Herbert";
        String phone = "123-456-789";
        int age = 10;
        String[] medications = {"Penny", "Ciline"};
        String[] allergies = {"Kindness"};
        String personFireAlertDTOToString = "PersonFireALertDTO{" +
                "lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medications=" + Arrays.toString(medications) +
                ", allergies=" + Arrays.toString(allergies) +
                '}';

        //WHEN
        personFireALertDTO.setLastName(lastName);
        personFireALertDTO.setPhone(phone);
        personFireALertDTO.setAge(age);
        personFireALertDTO.setMedications(medications);
        personFireALertDTO.setAllergies(allergies);

        //THEN
        Assertions.assertEquals(lastName, personFireALertDTO.getLastName());
        Assertions.assertEquals(phone, personFireALertDTO.getPhone());
        Assertions.assertEquals(age, personFireALertDTO.getAge());
        Assertions.assertEquals(medications, personFireALertDTO.getMedications());
        Assertions.assertEquals(allergies, personFireALertDTO.getAllergies());
        Assertions.assertEquals(personFireAlertDTOToString, personFireALertDTO.toString());
    }

    @Test
    public void testListPersonsFireAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        ListPersonsFireAlertDTO listPersonsFireAlertDTO = new ListPersonsFireAlertDTO();
        ArrayList<PersonFireALertDTO> fireAlertList = new ArrayList<>();
        int firestationNumber = 1;
        String listPersonsFireALertDTOToString = "ListPersonsFireAlertDTO{" +
                "firestationNumber=" + firestationNumber +
                ", persons=" + fireAlertList +
                '}';

        //WHEN
        listPersonsFireAlertDTO.setFirestationNumber(firestationNumber);
        listPersonsFireAlertDTO.setPersons(fireAlertList);

        //THEN
        Assertions.assertEquals(firestationNumber, listPersonsFireAlertDTO.getFirestationNumber());
        Assertions.assertEquals(fireAlertList, listPersonsFireAlertDTO.getPersons());
        Assertions.assertEquals(listPersonsFireALertDTOToString, listPersonsFireAlertDTO.toString());
    }

    @Test
    public void testPersonFloodAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonFloodAlertDTO personFloodAlertDTO = new PersonFloodAlertDTO();
        String lastName = "Potter";
        String address = "1 underStairs street";
        String phone = "123-456-789";
        int age = 7;
        String[] medications = {"Mandragore", "Butter beer"};
        String[] allergies = {"black magic"};
        String personFloodAlertDTOToString = "PersonFloodAlertDTO{" +
                "lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medications=" + Arrays.toString(medications) +
                ", allergies=" + Arrays.toString(allergies) +
                '}';

        //WHEN
        personFloodAlertDTO.setLastName(lastName);
        personFloodAlertDTO.setAddress(address);
        personFloodAlertDTO.setPhone(phone);
        personFloodAlertDTO.setAge(age);
        personFloodAlertDTO.setMedications(medications);
        personFloodAlertDTO.setAllergies(allergies);

        //THEN
        Assertions.assertEquals(lastName, personFloodAlertDTO.getLastName());
        Assertions.assertEquals(address, personFloodAlertDTO.getAddress());
        Assertions.assertEquals(phone, personFloodAlertDTO.getPhone());
        Assertions.assertEquals(age, personFloodAlertDTO.getAge());
        Assertions.assertEquals(medications, personFloodAlertDTO.getMedications());
        Assertions.assertEquals(allergies, personFloodAlertDTO.getAllergies());
        Assertions.assertEquals(personFloodAlertDTOToString, personFloodAlertDTO.toString());
    }

    @Test
    public void testListPersonsFloodAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        ListPersonsFloodAlertDTO listPersonsFloodAlertDTO = new ListPersonsFloodAlertDTO();
        ArrayList<PersonFloodAlertDTO> floodAlertList = new ArrayList<>();
        String listPersonsFloodAlertDTOToString = "{ persons=" + floodAlertList + '}';

        //WHEN
        listPersonsFloodAlertDTO.setPersons(floodAlertList);

        //THEN
        Assertions.assertEquals(floodAlertList, listPersonsFloodAlertDTO.getPersons());
        Assertions.assertEquals(listPersonsFloodAlertDTOToString, listPersonsFloodAlertDTO.toString());
    }

    @Test
    public void testPersonInfoAlertDTO_SetAndGetAllInfos(){
        //GIVEN
        PersonInfoAlertDTO personInfoAlertDTO = new PersonInfoAlertDTO();
        String lastName = "Doe";
        String address = "13 unknown street";
        int age = 38;
        String email = "jdoe@unknown.com";
        String[] medications = {"Mandragore", "Butter beer"};
        String[] allergies = {"black magic"};
        String personInfoAlertDTOToString = "PersonInfoAlertDTO{" +
                "lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", medications=" + Arrays.toString(medications) +
                ", allergies=" + Arrays.toString(allergies) +
                '}';

        //WHEN
        personInfoAlertDTO.setLastName(lastName);
        personInfoAlertDTO.setAddress(address);
        personInfoAlertDTO.setAge(age);
        personInfoAlertDTO.setEmail(email);
        personInfoAlertDTO.setMedications(medications);
        personInfoAlertDTO.setAllergies(allergies);

        //THEN
        Assertions.assertEquals(lastName, personInfoAlertDTO.getLastName());
        Assertions.assertEquals(address, personInfoAlertDTO.getAddress());
        Assertions.assertEquals(age, personInfoAlertDTO.getAge());
        Assertions.assertEquals(email, personInfoAlertDTO.getEmail());
        Assertions.assertEquals(medications, personInfoAlertDTO.getMedications());
        Assertions.assertEquals(allergies, personInfoAlertDTO.getAllergies());
        Assertions.assertEquals(personInfoAlertDTOToString, personInfoAlertDTO.toString());
    }

    @Test
    public void testListPersonsPersonInfoAlert_SetAndGetAllInfos(){
        //GIVEN
        ListPersonsPersonInfoAlertDTO listPersonsPersonInfoAlertDTO = new ListPersonsPersonInfoAlertDTO();
        ArrayList<PersonInfoAlertDTO> personInfoAlertList = new ArrayList<>();
        String listPersonsPersonInfoAlertDTOToString = "{ persons=" + personInfoAlertList + '}';

        //WHEN
        listPersonsPersonInfoAlertDTO.setPersons(personInfoAlertList);

        //THEN
        Assertions.assertEquals(personInfoAlertList, listPersonsPersonInfoAlertDTO.getPersons());
        Assertions.assertEquals(listPersonsPersonInfoAlertDTOToString, listPersonsPersonInfoAlertDTO.toString());
    }
}
