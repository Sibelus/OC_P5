package com.safetynet.api.service;

import com.safetynet.api.model.Person;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("person")
public class EndpointPersonService implements IEndpointPersonService {

    private static final Logger logger = LogManager.getLogger(EndpointPersonService.class);


    @Autowired
    PersonRepository personRepository;



    @Override
    public Person create(@NotNull Person person) {
        if(person.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + person.getLastName());
        }
        if(person.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + person.getLastName());
        }

        ArrayList<Person> allPersons = personRepository.getPersonsData();
        allPersons.add(person);
        logger.debug("{} {} is a new citizen of {}", person.getFirstName(), person.getLastName(), person.getCity());
        return person;
    }


    @Override
    public Person update(@NotNull Person person) {
        if(person.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + person.getLastName());
        }
        if(person.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + person.getLastName());
        }

        ArrayList<Person> allPersons = personRepository.getPersonsData();
        for(Person p : allPersons){
            if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())){
                p.setAddress(person.getAddress());
                p.setCity(person.getCity());
                p.setZip(person.getZip());
                p.setPhone(person.getPhone());
                p.setEmail(person.getEmail());
                logger.debug("Update {} {} personal infos", p.getFirstName(), p.getLastName());
            }
        }
        return person;
    }


    @Override
    public String delete(@NotNull Person person) {
        if(person.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + person.getFirstName());
        }
        if(person.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + person.getLastName());
        }
        if(person.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + person.getLastName());
        }

        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();
        ArrayList<Person> newPersonsList = personRepository.getPersonsAggregatedData();
        for (Person p : allPersons){
            if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())){
                newPersonsList.remove(p);
                logger.debug("Delete {} {} personal infos", p.getFirstName(), p.getLastName());
            }
        }
        return person.getFirstName() + " " + person.getLastName() + " was successfully deleted ";
    }
}
