package com.safetynet.api.service;

import com.safetynet.api.controller.FloodAlertController;
import com.safetynet.api.model.DTO.ListPersonsPersonInfoAlertDTO;
import com.safetynet.api.model.DTO.PersonInfoAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
public class PersonInfoAlertService implements IPersonInfoAlertService{

    private static final Logger logger = LogManager.getLogger(FloodAlertController.class);

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    public PersonInfoAlertDTO setPersonInfos(Person person){
        PersonInfoAlertDTO personInfoAlertDTO = new PersonInfoAlertDTO();
        personInfoAlertDTO.setLastName(person.getLastName());
        personInfoAlertDTO.setAddress(person.getAddress());
        personInfoAlertDTO.setAge(personService.calculateAge(person));
        personInfoAlertDTO.setEmail(person.getEmail());
        personInfoAlertDTO.setMedications(person.getMedications());
        personInfoAlertDTO.setAllergies(person.getAllergies());

        return personInfoAlertDTO;
    }

    @Override
    public ListPersonsPersonInfoAlertDTO getAlert(String firstName, String lastName) {
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonInfoAlertDTO> selectedPersons = new ArrayList<>();

        for(Person person : allPersons){
            if(firstName == null || firstName.equals("")){
                logger.error("Firstname provided is null or empty");
                throw new IllegalArgumentException("Firstname provided is incorrect: " + firstName);
            }
            if(lastName == null || lastName.equals("")){
                logger.error("Lastname provided is null or empty");
                throw new IllegalArgumentException("Lastname provided is incorrect: " + lastName);
            }

            if(person.getLastName().equals(lastName)){
                PersonInfoAlertDTO personInfoAlertDTO = setPersonInfos(person);
                selectedPersons.add(personInfoAlertDTO);
            }

        }
        ListPersonsPersonInfoAlertDTO listPersonsPersonInfoAlertDTO = new ListPersonsPersonInfoAlertDTO();
        listPersonsPersonInfoAlertDTO.setPersons(selectedPersons);
        return listPersonsPersonInfoAlertDTO;
    }
}
