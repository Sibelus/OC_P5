package com.safetynet.api.service;

import com.safetynet.api.model.Firestation;
import com.safetynet.api.model.Medicalrecord;
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
public class EndpointServiceTest {

    @MockBean
    private PersonRepository personRepository;
    @Autowired
    private EndpointPersonService endpointPersonService;
    @Autowired
    private EndpointFirestationService endpointFirestationService;
    @Autowired
    private EndpointMedicalRecordService endpointMedicalRecordService;


    /* ----- CREATE -----*/
    //Person
    @Test
    public void testEndpointPersonService_CreateNewPerson(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("Tensile");

        //WHEN
        Person newPerson = endpointPersonService.create(person);

        //THEN
        Assertions.assertEquals("Magnus", person.getFirstName());
        Assertions.assertEquals("Tensile", person.getLastName());
    }

    @Test
    public void testEndpointPersonService_CreateNewPerson_NullFirstname(){
        //GIVEN
        Person person = new Person();
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.create(person));
    }

    @Test
    public void testEndpointPersonService_CreateNewPerson_EmptyFirstname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.create(person));
    }

    @Test
    public void testEndpointPersonService_CreateNewPerson_NullLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.create(person));
    }

    @Test
    public void testEndpointPersonService_CreateNewPerson_EmptyLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.create(person));
    }


    //Firestation
    @Test
    public void testEndpointFirestationService_CreateNewFirestation(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(1);

        //WHEN
        Firestation newFirestation = endpointFirestationService.create(firestation);

        //THEN
        Assertions.assertEquals("Last seat on the beach", newFirestation.getAddress());
        Assertions.assertEquals(1, newFirestation.getStation());
    }

    @Test
    public void testEndpointFirestationService_CreateNewFirestation_NullAddress(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setStation(1);

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointFirestationService.create(firestation));
    }

    @Test
    public void testEndpointFirestationService_CreateNewFirestation_EmptyAddress(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("");
        firestation.setStation(1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.create(firestation));
    }

    @Test
    public void testEndpointFirestationService_CreateNewFirestation_NegativeStationNumber(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(-1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.create(firestation));
    }


    //Medicalrecord
    @Test
    public void testEndpointMedicalrecordService_CreateNewMedicalrecord(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("Terature");

        //WHEN
        Medicalrecord newMedicalrecord = endpointMedicalRecordService.create(medicalrecord);

        //THEN
        Assertions.assertEquals("Ali", newMedicalrecord.getFirstName());
        Assertions.assertEquals("Terature", newMedicalrecord.getLastName());
    }

    @Test
    public void testEndpointMedicalrecordService_CreateNewMedicalrecord_NullFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.create(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_CreateNewMedicalrecord_EmptyFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("");
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.create(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_CreateNewMedicalrecord_NullLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.create(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_CreateNewMedicalrecord_EmptyLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.create(medicalrecord));
    }



    /* ----- UPDATE -----*/
    //Person
    @Test
    public void testEndpointPersonService_UpdatePerson(){
        //GIVEN
        ArrayList<Person> allPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("Tensile");
        person.setAddress("13 cross road");

        Person newPerson = new Person();
        newPerson.setFirstName("Magnus");
        newPerson.setLastName("Tensile");
        newPerson.setAddress("221 B Backer street");

        allPersons.add(person);
        when(personRepository.getPersonsData()).thenReturn(allPersons);

        //WHEN
        Person updatedPerson = endpointPersonService.update(newPerson);

        //THEN
        Assertions.assertEquals("221 B Backer street", updatedPerson.getAddress());
    }

    @Test
    public void testEndpointPersonService_UpdatePerson_NullFirstname(){
        //GIVEN
        Person person = new Person();
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.update(person));
    }

    @Test
    public void testEndpointPersonService_UpdatePerson_EmptyFirstname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.update(person));
    }

    @Test
    public void testEndpointPersonService_UpdatePerson_NullLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.update(person));
    }

    @Test
    public void testEndpointPersonService_UpdatePerson_EmptyLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.update(person));
    }


    //Firestation
    @Test
    public void testEndpointFirestationService_UpdateFirestation(){
        //GIVEN
        ArrayList<Firestation> allFirestations = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(1);

        Firestation newFirestation = new Firestation();
        newFirestation.setAddress("Last seat on the beach");
        newFirestation.setStation(42);

        allFirestations.add(firestation);
        when(personRepository.getFirestationsData()).thenReturn(allFirestations);

        //WHEN
        Firestation updatedFirestation = endpointFirestationService.update(newFirestation);

        //THEN
        Assertions.assertEquals(42, newFirestation.getStation());
    }

    @Test
    public void testEndpointFirestationService_UpdateFirestation_NullAddress(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setStation(1);

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointFirestationService.update(firestation));
    }

    @Test
    public void testEndpointFirestationService_UpdateFirestation_EmptyAddress(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("");
        firestation.setStation(1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.update(firestation));
    }

    @Test
    public void testEndpointFirestationService_UpdateFirestation_NegativeStationNumber(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(-1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.update(firestation));
    }


    //Medicalrecord
    @Test
    public void testEndpointMedicalrecordService_UpdateMedicalrecord(){
        //GIVEN
        ArrayList<Medicalrecord> allMedicalrecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("Terature");
        medicalrecord.setBirthdate("13/01/2013");

        Medicalrecord newMedicalrecord = new Medicalrecord();
        newMedicalrecord.setFirstName("Ali");
        newMedicalrecord.setLastName("Terature");
        newMedicalrecord.setBirthdate("23/12/2042");

        allMedicalrecords.add(medicalrecord);
        when(personRepository.getMedicalrecordsData()).thenReturn(allMedicalrecords);

        //WHEN
        Medicalrecord updatedMedicalrecord = endpointMedicalRecordService.update(newMedicalrecord);

        //THEN
        Assertions.assertEquals("23/12/2042", updatedMedicalrecord.getBirthdate());
    }

    @Test
    public void testEndpointMedicalrecordService_UpdateMedicalrecord_NullFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.update(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_UpdateMedicalrecord_EmptyFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("");
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.update(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_UpdateMedicalrecord_NullLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.update(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_UpdateMedicalrecord_EmptyLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.update(medicalrecord));
    }




    /* ----- DELETE -----*/
    //Person
    @Test
    public void testEndpointPersonService_DeletePerson(){
        //GIVEN
        ArrayList<Person> allPersons = new ArrayList<>();
        ArrayList<Person> newPersonsList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("Tensile");

        allPersons.add(person);
        when(personRepository.getPersonsAggregatedData()).thenReturn(allPersons);
        when(personRepository.getPersonsAggregatedData()).thenReturn(newPersonsList);

        //WHEN
        String deletedPerson = endpointPersonService.delete(person);

        //THEN
        Assertions.assertEquals("Magnus Tensile was successfully deleted ", deletedPerson);
    }

    @Test
    public void testEndpointPersonService_DeletePerson_NullFirstname(){
        //GIVEN
        Person person = new Person();
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.delete(person));
    }

    @Test
    public void testEndpointPersonService_DeletePerson_EmptyFirstname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("Tensile");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.delete(person));
    }

    @Test
    public void testEndpointPersonService_DeletePerson_NullLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointPersonService.delete(person));
    }

    @Test
    public void testEndpointPersonService_DeletePerson_EmptyLastname(){
        //GIVEN
        Person person = new Person();
        person.setFirstName("Magnus");
        person.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointPersonService.delete(person));
    }


    //Firestation
    @Test
    public void testEndpointFirestationService_DeleteFirestation(){
        //GIVEN
        ArrayList<Firestation> allFirestations = new ArrayList<>();
        ArrayList<Firestation> newFirestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(1);

        allFirestations.add(firestation);
        when(personRepository.getFirestationsData()).thenReturn(allFirestations);
        when(personRepository.getFirestationsData()).thenReturn(newFirestationList);

        //WHEN
        String deletedFirestation = endpointFirestationService.delete(firestation);

        //THEN
        Assertions.assertEquals("Firestation was successfully deleted", deletedFirestation);
    }

    @Test
    public void testEndpointFirestationService_DeleteFirestation_EmptyAddress(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("");
        firestation.setStation(1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.delete(firestation));
    }

    @Test
    public void testEndpointFirestationService_DeleteFirestation_NegativeStationNumber(){
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("Last seat on the beach");
        firestation.setStation(-1);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointFirestationService.delete(firestation));
    }


    //Medicalrecord
    @Test
    public void testEndpointMedicalrecordService_DeleteMedicalrecord(){
        //GIVEN
        ArrayList<Medicalrecord> allMedicalrecordss = new ArrayList<>();
        ArrayList<Medicalrecord> newMedicalrecordList = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("Terature");

        allMedicalrecordss.add(medicalrecord);
        when(personRepository.getMedicalrecordsData()).thenReturn(allMedicalrecordss);
        when(personRepository.getMedicalrecordsData()).thenReturn(newMedicalrecordList);

        //WHEN
        String deletedMedicalrecord = endpointMedicalRecordService.delete(medicalrecord);

        //THEN
        Assertions.assertEquals("medicalrecord for Ali Terature was successfully deleted", deletedMedicalrecord);
    }

    @Test
    public void testEndpointMedicalrecordService_DeleteMedicalrecord_NullFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.delete(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_DeleteMedicalrecord_EmptyFirstname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("");
        medicalrecord.setLastName("Terature");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.delete(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_DeleteMedicalrecord_NullLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");

        //THEN
        Assertions.assertThrows(NullPointerException.class, ()-> endpointMedicalRecordService.delete(medicalrecord));
    }

    @Test
    public void testEndpointMedicalrecordService_DeleteMedicalrecord_EmptyLastname(){
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Ali");
        medicalrecord.setLastName("");

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, ()-> endpointMedicalRecordService.delete(medicalrecord));
    }
}
