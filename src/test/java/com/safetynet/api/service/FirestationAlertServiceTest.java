package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.model.DTO.PersonFirestationAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


@SpringBootTest
public class FirestationAlertServiceTest {

    @MockBean
    private PersonService personService;
    @MockBean
    private PersonFirestationAlertDTO personFirestationAlertDTO;
    @MockBean
    private ListPersonsFirestationAlertDTO firestationAlertList;
    @MockBean
    private PersonRepository personRepository;

    /*
    @Test
    public void testGetFirestationAlert(){
        //GIVEN
        Person person = new Person();
        person.setStation(1);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("221 B backer street");
        person.setPhone("000-000-000");
        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPerson);

        //WHEN
        FirestationAlertService firestationAlertService = new FirestationAlertService();
        firestationAlertService.getFirestationAlert(1);

        //THEN
        ArrayList<PersonFirestationAlertDTO> selectedPersons = firestationAlertList.getPersons();
        personFirestationAlertDTO = selectedPersons.get(0);
        Assertions.assertEquals("John", personFirestationAlertDTO.getFirstName());
    }*/
}
