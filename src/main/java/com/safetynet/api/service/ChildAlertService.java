package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsChildAlertDTO;
import com.safetynet.api.model.DTO.PersonChildAlertDTO;
import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class ChildAlertService {

    private static final Logger logger = LogManager.getLogger(FirestationAlertService.class);

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    public ListPersonsChildAlertDTO getChildAlert(String address){


        ListPersonsChildAlertDTO listPersonsChildAlertDTO = new ListPersonsChildAlertDTO();

        ArrayList<PersonChildAlertDTO> allResident = getResident(address);
        ArrayList<PersonChildAlertDTO> childrenList = getChildrenList(allResident);

        for(PersonChildAlertDTO child : childrenList){
            ArrayList<PersonChildAlertDTO> familyMember = getResident(address);
            ArrayList<PersonChildAlertDTO> otherFamilyMember = new ArrayList<>();

            for(PersonChildAlertDTO p : familyMember){
                if(!Objects.equals(p.getFirstName(), child.getFirstName())){
                    otherFamilyMember.add(p);
                }
            }
            child.setOtherFamillyMembers(otherFamilyMember);
        }

        /*
        for(PersonChildAlertDTO child : childrenList){
            ArrayList<PersonChildAlertDTO> familyMember = getResident(address);
            familyMember.remove(child);
            child.setOtherFamillyMembers(familyMember);
        }*/

        listPersonsChildAlertDTO.setChildrenAndTheirFamily(childrenList);
        return listPersonsChildAlertDTO;
    }


    private ArrayList<PersonChildAlertDTO> getResident(String address){
        ArrayList<PersonChildAlertDTO> selectedPersons = new ArrayList<>();
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();

        //Select persons living at the provided address
        for(Person person : allPersons){
            if(address == null || address.equals("")){
                logger.error("Address provided is null or empty");
                throw new IllegalArgumentException("Address provided is incorrect: " + address);
            }
            if(Objects.equals(person.getAddress(), address)){
                PersonChildAlertDTO personChildAlertDTO = new PersonChildAlertDTO();
                personChildAlertDTO.setFirstName(person.getFirstName());
                personChildAlertDTO.setLastName(person.getLastName());
                personChildAlertDTO.setAge(personService.calculateAge(person));
                selectedPersons.add(personChildAlertDTO);
                logger.debug("{} {} live at {}", personChildAlertDTO.getFirstName(), personChildAlertDTO.getLastName(), address);
            }
        }
        return selectedPersons;
    }

    private ArrayList<PersonChildAlertDTO> getChildrenList(ArrayList<PersonChildAlertDTO> persons){
        ArrayList<PersonChildAlertDTO> childrenList = new ArrayList<>();

        //Select children
        for(PersonChildAlertDTO child : persons){
            if(!personService.isAnAdult(child.getAge())){
                childrenList.add(child);
                logger.debug("{} {} added to childrenList", child.getFirstName(), child.getLastName());
            }
        }
        return childrenList;
    }
}
