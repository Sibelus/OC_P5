package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsCommunityEmailAlertDTO;
import com.safetynet.api.model.DTO.PersonCommunityEmailDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
public class CommunityEmailAlertService implements ICommunityEmailAlertService{

    private static final Logger logger = LogManager.getLogger(CommunityEmailAlertService.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public ListPersonsCommunityEmailAlertDTO getAlert(String city) {
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<PersonCommunityEmailDTO> selectedPersons = new ArrayList<>();

        for(Person person : allPersons){
            if(city == null || city.equals("")){
                logger.error("City provided is null or empty");
                throw new IllegalArgumentException("City provided is incorrect: " + city);
            }
            if (person.getCity().equals(city)){
                PersonCommunityEmailDTO personCommunityEmailDTO =new PersonCommunityEmailDTO();
                personCommunityEmailDTO.setEmail(person.getEmail());
                selectedPersons.add(personCommunityEmailDTO);
            }
        }

        ListPersonsCommunityEmailAlertDTO listPersonsCommunityEmailAlertDTO = new ListPersonsCommunityEmailAlertDTO();
        listPersonsCommunityEmailAlertDTO.setCommunityEmailAlertList(selectedPersons);
        return listPersonsCommunityEmailAlertDTO;
    }
}
