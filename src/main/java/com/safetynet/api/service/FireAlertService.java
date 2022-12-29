package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFireAlertDTO;
import com.safetynet.api.model.DTO.PersonFireALertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component("fireAlert")
public class FireAlertService implements IAlertService{

    private static final Logger logger = LogManager.getLogger(FireAlertService.class);

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Override
    public Object getAlert(Object ... object) {
        String address = (String) object[0];
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonFireALertDTO> selectedPersons = new ArrayList<>();
        int firestationNumber = 0;

        for(Person person : allPersons){
            if(address == null || address.equals("")){
                logger.error("Address provided is null or empty");
                throw new IllegalArgumentException("Address provided is incorrect: " + address);
            }
            if(person.getAddress().equals(address)){
                PersonFireALertDTO personFireALertDTO = new PersonFireALertDTO();
                personFireALertDTO.setLastName(person.getLastName());
                personFireALertDTO.setPhone(person.getPhone());
                personFireALertDTO.setAge(personService.calculateAge(person));
                personFireALertDTO.setMedications(person.getMedications());
                personFireALertDTO.setAllergies(person.getAllergies());
                selectedPersons.add(personFireALertDTO);

                firestationNumber = person.getStation();
            }
        }
        ListPersonsFireAlertDTO fireAlertList = new ListPersonsFireAlertDTO();
        fireAlertList.setFirestationNumber(firestationNumber);
        fireAlertList.setPersons(selectedPersons);
        return fireAlertList;
    }
}
