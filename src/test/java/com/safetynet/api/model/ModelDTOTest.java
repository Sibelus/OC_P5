package com.safetynet.api.model;

import com.safetynet.api.model.DTO.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}
