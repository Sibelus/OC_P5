package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.model.DTO.PersonFirestationAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;



@Service
public class FirestationAlertService {

    private static final Logger logger = LogManager.getLogger(FirestationAlertService.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    public ListPersonsFirestationAlertDTO getFirestationAlert(int firestationNumber){
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonFirestationAlertDTO> selectedPersons = new ArrayList<>();

        int adults = 0;
        int children = 0;

        for(Person person : allPersons){
            logger.debug("{} {} depends of firestation number {}",person.getFirstName(), person.getLastName(), person.getStation());
            if(Objects.equals(person.getStation(), firestationNumber)){
                PersonFirestationAlertDTO personFirestationAlertDTO = new PersonFirestationAlertDTO();
                personFirestationAlertDTO.setFirstName(person.getFirstName());
                personFirestationAlertDTO.setLastName(person.getLastName());
                personFirestationAlertDTO.setAddress(person.getAddress());
                personFirestationAlertDTO.setPhone(person.getPhone());

                selectedPersons.add(personFirestationAlertDTO);
                logger.debug("Add {} {} to the list", personFirestationAlertDTO.getFirstName(), personFirestationAlertDTO.getLastName());

                if(personService.isAnAdult(personService.calculateAge(person))){
                    adults += 1;
                    logger.debug("{} {} is an adult, adults counter = {}", personFirestationAlertDTO.getFirstName(), personFirestationAlertDTO.getLastName(), adults);
                } else {
                    children += 1;
                    logger.debug("{} {} is a child, children counter = {}", personFirestationAlertDTO.getFirstName(), personFirestationAlertDTO.getLastName(), children);
                }
            }
        }

        ListPersonsFirestationAlertDTO firestationAlertList = new ListPersonsFirestationAlertDTO();
        firestationAlertList.setChildren(children);
        firestationAlertList.setAdults(adults);
        firestationAlertList.setPersons(selectedPersons);

        return firestationAlertList;
    }
}
