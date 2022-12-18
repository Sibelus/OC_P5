package com.safetynet.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {
    @MockBean
    ObjectMapper objectMapper;

    @Test
    public void testAggregateData() throws IOException {
        //GIVEN
        PersonRepository personRepository = new PersonRepository();
        ArrayList<Person> personArrayList = new ArrayList<>();
        Persons persons = new Persons();
        Person person = new Person();
        person.setFirstName("Marie");
        person.setLastName("Tournelle");
        person.setAddress("1 turnaround street");
        personArrayList.add(person);
        persons.setPersons(personArrayList);

        ArrayList<Firestation> firestationArrayList = new ArrayList<>();
        Firestations firestations = new Firestations();
        Firestation firestation = new Firestation();
        firestation.setAddress("1 turnaround street");
        firestation.setStation(1);
        firestationArrayList.add(firestation);
        firestations.setFirestations(firestationArrayList);

        ArrayList<Medicalrecord> medicalrecordArrayList = new ArrayList<>();
        Medicalrecords medicalrecords = new Medicalrecords();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Marie");
        medicalrecord.setLastName("Tournelle");
        medicalrecord.setBirthdate("03/01/1985");
        medicalrecord.setMedications(new String[]{"honey", "lemon"});
        medicalrecord.setAllergies(new String[]{"milk"});
        medicalrecordArrayList.add(medicalrecord);
        medicalrecords.setMedicalrecords(medicalrecordArrayList);

        when(objectMapper.readValue((Mockito.anyString(), Mockito.any(Class.class))), Persons.class)).thenReturn(persons);
        when(objectMapper.readValue(new File(anyString(), eq("src/main/resources/data.json")), Firestations.class)).thenReturn(firestations);
        when(objectMapper.readValue(new File(anyString(), eq("src/main/resources/data.json")), Medicalrecords.class)).thenReturn(medicalrecords);

        //WHEN
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();

        //THEN
        Assertions.assertEquals(allPersons.get(0).getStation(), 1);
        Assertions.assertEquals(allPersons.get(0).getBirthdate(), "03/01/1985");
        Assertions.assertEquals(allPersons.get(0).getMedications(), new String[]{"honey", "lemon"});
        Assertions.assertEquals(allPersons.get(0).getAllergies(), new String[]{"milk"});
    }
}
