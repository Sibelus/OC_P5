package com.safetynet.api.service;

import com.safetynet.api.controller.FloodAlertController;
import com.safetynet.api.model.DTO.ListPersonsFloodAlertDTO;
import com.safetynet.api.model.DTO.PersonFloodAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FloodAlertService {

    private static final Logger logger = LogManager.getLogger(FloodAlertController.class);

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    public ListPersonsFloodAlertDTO getFloodAlert(List<Integer> listFirestationNumber){
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonFloodAlertDTO> selectedPersons = new ArrayList<>();

        for(int firestationNumber : listFirestationNumber){
            for(Person person : allPersons){
                if(Objects.equals(person.getStation(), firestationNumber)){
                    logger.debug("{} {} depends of firestation {}", person.getFirstName(), person.getLastName(), person.getStation());
                    PersonFloodAlertDTO personFloodAlertDTO = new PersonFloodAlertDTO();
                    personFloodAlertDTO.setLastName(person.getLastName());
                    personFloodAlertDTO.setAddress(person.getAddress());
                    personFloodAlertDTO.setAge(personService.calculateAge(person));
                    personFloodAlertDTO.setPhone(person.getPhone());
                    personFloodAlertDTO.setMedications(person.getMedications());
                    personFloodAlertDTO.setAllergies(person.getAllergies());
                    selectedPersons.add(personFloodAlertDTO);
                    logger.debug("Added to the selectedPersons list");
                }
            }
        }

        //tri par nom
        Collections.sort(selectedPersons, PersonFloodAlertDTO.ComparatorAddress);
        logger.debug("Sorting the list by address");

        ListPersonsFloodAlertDTO listPersonsFloodAlertDTO = new ListPersonsFloodAlertDTO();
        listPersonsFloodAlertDTO.setPersons(selectedPersons);
        return listPersonsFloodAlertDTO;
    }
}
