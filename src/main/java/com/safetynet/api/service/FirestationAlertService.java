package com.safetynet.api.service;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;
import com.safetynet.api.model.DTO.PersonFirestationAlertDTO;
import com.safetynet.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.safetynet.api.model.Person;



@Service
public class FirestationAlertService {

    @Autowired
    private PersonService personService;

    public ListPersonsFirestationAlertDTO getFirestationAlert(int firestationNumber){
        ArrayList<Person> allPersons = PersonRepository.getPersonsAggregatedData();
        ArrayList<PersonFirestationAlertDTO> selectedPersons = new ArrayList<>();
        ListPersonsFirestationAlertDTO firestationAlertList = new ListPersonsFirestationAlertDTO();

        int adults = 0;
        int children = 0;

        for(Person person : allPersons){
            if(Objects.equals(person.getStation(), firestationNumber)){
                PersonFirestationAlertDTO personFirestationAlertDTO = new PersonFirestationAlertDTO();
                personFirestationAlertDTO.setFirstName(person.getFirstName());
                personFirestationAlertDTO.setLastName(person.getLastName());
                personFirestationAlertDTO.setAddress(person.getAddress());
                personFirestationAlertDTO.setPhone(person.getPhone());

                selectedPersons.add(personFirestationAlertDTO);

                if(personService.isAnAdult(personService.calculateAge(person))){
                    adults += 1;
                } else {
                    children += 1;
                }
            }
        }

        firestationAlertList.setChildren(children);
        firestationAlertList.setAdults(adults);
        firestationAlertList.setPersons(selectedPersons);

        return firestationAlertList;
    }
}
