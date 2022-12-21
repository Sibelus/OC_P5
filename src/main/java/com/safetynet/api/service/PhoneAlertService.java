package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListePersonsPhoneAlertDTO;
import com.safetynet.api.model.DTO.PersonPhoneAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PhoneAlertService {

    private static final Logger logger = LogManager.getLogger(PhoneAlertService.class);

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ListePersonsPhoneAlertDTO listePersonsPhoneAlertDTO;

    public ListePersonsPhoneAlertDTO getPhoneAlert(int firestationNumber){
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonPhoneAlertDTO> selectedPersons = new ArrayList<>();

        for(Person person : allPersons){
            logger.debug("{} {} depends of firestation number {}",person.getFirstName(), person.getLastName(), person.getStation());
            if(Objects.equals(person.getStation(), firestationNumber)){
                PersonPhoneAlertDTO personPhoneAlertDTO = new PersonPhoneAlertDTO();
                personPhoneAlertDTO.setPhone(person.getPhone());
                selectedPersons.add(personPhoneAlertDTO);
                logger.debug("Add {} to the list", personPhoneAlertDTO.getPhone());
            }
        }
        listePersonsPhoneAlertDTO.setPhoneAlertList(selectedPersons);
        return listePersonsPhoneAlertDTO;
    }
}
