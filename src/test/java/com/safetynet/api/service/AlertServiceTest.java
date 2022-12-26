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
import java.util.Arrays;

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
    @Autowired
    private FloodAlertService floodAlertService;
    @Autowired
    private PersonInfoAlertService personInfoAlertService;
    @Autowired
    private CommunityEmailAlertService communityEmailAlertService;


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

    @Test
    public void testGetFloodAlert(){
        //GIVEN
        Person person1 = new Person();
        person1.setLastName("Potter");
        person1.setAddress("1 underStairs street");
        person1.setPhone("123-456-789");
        person1.setStation(1);
        person1.setBirthdate("12/12/2012");
        person1.setMedications(new String[]{"Mandragore", "Butter beer"});
        person1.setAllergies(new String[]{"black magic"});

        Person person2 = new Person();
        person2.setLastName("Palmer");
        person2.setAddress("1 underStairs street");
        person2.setPhone("123-456-789");
        person2.setStation(1);
        person2.setBirthdate("12/12/1982");
        person2.setMedications(new String[]{"Penny", "Ciline"});
        person2.setAllergies(new String[]{"black magic"});

        Person person3 = new Person();
        person3.setLastName("Dumbledor");
        person3.setAddress("Poudlard castle");
        person3.setPhone("123-456-789");
        person3.setStation(1);
        person3.setBirthdate("12/12/2012");
        person3.setMedications(new String[]{"Mandragore", "Butter beer"});
        person3.setAllergies(new String[]{"black magic"});

        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(person1);
        allPersons.add(person2);
        allPersons.add(person3);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPersons);

        ArrayList<Integer> firestationNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));


        //WHEN
        ListPersonsFloodAlertDTO listPersonsFloodAlertDTO = floodAlertService.getFloodAlert(firestationNumberList);
        ArrayList<PersonFloodAlertDTO> selectedPersons = listPersonsFloodAlertDTO.getPersons();
        PersonFloodAlertDTO personFloodAlertDTO1 = selectedPersons.get(0);
        PersonFloodAlertDTO personFloodAlertDTO2 = selectedPersons.get(1);
        PersonFloodAlertDTO personFloodAlertDTO3 = selectedPersons.get(2);

        //THEN
        Assertions.assertEquals(personFloodAlertDTO1.getAddress(), personFloodAlertDTO2.getAddress());
        Assertions.assertEquals("Poudlard castle", personFloodAlertDTO3.getAddress());
    }

    @Test
    public void testGetPersonInfoAlert(){
        //GIVEN
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setAddress("13 unknown street");
        person1.setBirthdate("12/12/1982");
        person1.setEmail("jdoe@unknown.com");
        person1.setMedications(new String[]{"Penny", "Ciline"});
        person1.setAllergies(new String[]{"kindness"});

        Person person2 = new Person();
        person2.setFirstName("Karen");
        person2.setLastName("Doe");
        person2.setAddress("1 unknown street");
        person2.setBirthdate("12/12/2002");
        person2.setEmail("kdoe@unknown.com");
        person2.setMedications(new String[]{"Penny", "Ciline"});
        person2.setAllergies(new String[]{"kindness"});

        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(person1);
        allPersons.add(person2);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPersons);

        //WHEN
        ListPersonsPersonInfoAlertDTO listPersonsPersonInfoAlertDTO = personInfoAlertService.getPersonInfoAlert("John", "Doe");
        ArrayList<PersonInfoAlertDTO> selectedPersons = listPersonsPersonInfoAlertDTO.getPersons();
        PersonInfoAlertDTO personInfoAlertDTO1 = selectedPersons.get(0);
        PersonInfoAlertDTO personInfoAlertDTO2 = selectedPersons.get(1);

        //THEN
        Assertions.assertEquals("jdoe@unknown.com", personInfoAlertDTO1.getEmail());
        Assertions.assertEquals("kdoe@unknown.com", personInfoAlertDTO2.getEmail());
    }

    @Test
    public void testGetCommunityEmailAlert(){
        //GIVEN
        Person person = new Person();
        person.setEmail("jdoe@unknown.com");
        person.setCity("Culver");

        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPersons);

        //WHEN
        ListPersonsCommunityEmailAlertDTO listPersonsCommunityEmailAlertDTO = communityEmailAlertService.getCommunityEmailAlert("Culver");
        ArrayList<PersonCommunityEmailDTO> selectedPersons = listPersonsCommunityEmailAlertDTO.getCommunityEmailAlertList();
        PersonCommunityEmailDTO personCommunityEmailDTO = selectedPersons.get(0);

        //THEN
        Assertions.assertEquals("jdoe@unknown.com", personCommunityEmailDTO.getEmail());
    }
}
