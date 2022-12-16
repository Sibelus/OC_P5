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
            ArrayList<PersonChildAlertDTO> otherfamilyMember = new ArrayList<>();

            for(PersonChildAlertDTO p : familyMember){
                if(!Objects.equals(p.getFirstname(), child.getFirstname())){
                    otherfamilyMember.add(p);
                }
            }
            child.setOtherFamillyMembers(otherfamilyMember);
        }

        /*
        for(PersonChildAlertDTO child : childrenList){
            ArrayList<PersonChildAlertDTO> familyMember = getResident(address);
            familyMember.remove(child);
            child.setOtherFamillyMembers(familyMember);
        }*/

        listPersonsChildAlertDTO.setChildrenAndTheirFamilly(childrenList);
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
                personChildAlertDTO.setFirstname(person.getFirstName());
                personChildAlertDTO.setLastname(person.getLastName());
                personChildAlertDTO.setAge(personService.calculateAge(person));
                selectedPersons.add(personChildAlertDTO);
            }
        }
        return selectedPersons;
    }

    private ArrayList<PersonChildAlertDTO> getChildrenList(ArrayList<PersonChildAlertDTO> persons){
        ArrayList<PersonChildAlertDTO> childrenList = new ArrayList<>();
        ArrayList<PersonChildAlertDTO> allResident = persons;

        //Select children
        for(PersonChildAlertDTO child : allResident){
            if(!personService.isAnAdult(child.getAge())){
                childrenList.add(child);
            }
        }
        return childrenList;
    }
}
