package com.safetynet.api.service;

import com.safetynet.api.model.DTO.*;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


@SpringBootTest
public class AlertServiceTest {

    @MockBean
    private PersonRepository personRepository;
    @Autowired
    private FirestationAlertService firestationAlertService;
    @Autowired
    private ChildAlertService childAlertService;
    @Autowired
    private PhoneAlertService phoneAlertService;
    @Autowired
    private FireAlertService fireAlertService;


    @Test
    public void testGetFirestationAlert_ForAnAdult(){
        //GIVEN
        Person person = new Person();
        person.setStation(1);
        person.setFirstName("John");
        person.setBirthdate("12/12/1985");
        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPerson);

        //WHEN
        ListPersonsFirestationAlertDTO listPersonsFirestationAlertDTO = firestationAlertService.getFirestationAlert(1);
        ArrayList<PersonFirestationAlertDTO> selectedPersons = listPersonsFirestationAlertDTO.getPersons();
        PersonFirestationAlertDTO personFirestationAlertDTO = selectedPersons.get(0);

        //THEN
        Assertions.assertEquals("John", personFirestationAlertDTO.getFirstName());
        Assertions.assertEquals(1, listPersonsFirestationAlertDTO.getAdults());
    }

    @Test
    public void testGetFirestationAlert_ForAChild(){
        //GIVEN
        Person person = new Person();
        person.setStation(1);
        person.setBirthdate("12/12/2012");
        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPerson);

        //WHEN
        ListPersonsFirestationAlertDTO listPersonsFirestationAlertDTO = firestationAlertService.getFirestationAlert(1);

        //THEN
        Assertions.assertEquals(1, listPersonsFirestationAlertDTO.getChildren());
    }

    @Test
    public void testGetChildAlert(){
        //GIVEN
        Person child = new Person();
        child.setFirstName("Sherlock");
        child.setLastName("Holmes");
        child.setAddress("221 B backer street");
        child.setBirthdate("12/12/2012");

        Person adult = new Person();
        adult.setFirstName("Mycroft");
        adult.setAddress("221 B backer street");
        adult.setBirthdate("12/12/1972");

        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(child);
        allPerson.add(adult);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPerson);

        //WHEN
        ListPersonsChildAlertDTO listPersonsChildAlertDTO = childAlertService.getChildAlert("221 B backer street");
        ArrayList<PersonChildAlertDTO> selectedPersons = listPersonsChildAlertDTO.getChildrenAndTheirFamily();
        PersonChildAlertDTO personChildAlertDTO = selectedPersons.get(0);

        //THEN
        Assertions.assertEquals("Sherlock", personChildAlertDTO.getFirstName());
        Assertions.assertEquals("Mycroft", personChildAlertDTO.getOtherFamillyMembers().get(0).getFirstName());
    }

    @Test
    public void testGetPhoneALert(){
        //GIVEN
        Person person =new Person();
        person.setStation(1);
        person.setPhone("123-456-789");

        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPerson);

        //WHEN
        ListePersonsPhoneAlertDTO listePersonsPhoneAlertDTO = phoneAlertService.getPhoneAlert(1);
        ArrayList<PersonPhoneAlertDTO> selectedPersons = listePersonsPhoneAlertDTO.getPhoneAlertList();
        PersonPhoneAlertDTO personPhoneAlertDTO = selectedPersons.get(0);

        //THEN
        Assertions.assertEquals("123-456-789", personPhoneAlertDTO.getPhone());
    }

    @Test
    public void testGetFireAlert(){
        //GIVEN
        Person person = new Person();
        person.setLastName("Herbert");
        person.setPhone("123-456-789");
        person.setAddress("31 jump street");
        person.setBirthdate("12/12/2012");
        person.setStation(1);
        person.setMedications(new String[]{"Penny", "Ciline"});
        person.setAllergies(new String[]{"kindness"});

        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPersons);

        //WHEN
        ListPersonsFireAlertDTO listPersonsFireAlertDTO = fireAlertService.getFireAlert("31 jump street");
        ArrayList<PersonFireALertDTO> selectedPersons = listPersonsFireAlertDTO.getPersons();
        PersonFireALertDTO personFireALertDTO = selectedPersons.get(0);
        int firestationNumber = listPersonsFireAlertDTO.getFirestationNumber();

        //THEN
        Assertions.assertEquals(1, firestationNumber);
        Assertions.assertEquals("Herbert", personFireALertDTO.getLastName());
    }
}
