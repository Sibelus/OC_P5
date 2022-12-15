package com.safetynet.api.model;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.model.DTO.PersonFirestationAlertDTO;
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
}
