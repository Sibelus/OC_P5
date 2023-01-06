package com.safetynet.api.controller;

import com.safetynet.api.model.Person;
import com.safetynet.api.service.IEndpointPersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
public class EndpointPersonController {

    private static final Logger logger = LogManager.getLogger(EndpointPersonController.class);

    @Autowired
    IEndpointPersonService endpointPersonService;




    @PostMapping(value = "/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        logger.info("Request create a new {}", person);
        Person personAdded = endpointPersonService.create(person);
        if (Objects.isNull(personAdded)) {
            logger.error("Null object provided : {}", personAdded);
            return ResponseEntity.noContent().build();
        }

        logger.info("Return {}",ResponseEntity.created(URI.create("/person")).body(personAdded));
        return ResponseEntity.created(URI.create("/person")).body(personAdded);
    }

    @PutMapping(value = "/person")
    public Person updatePerson(@RequestBody Person person) {
        logger.info("Request update {} {} infos", person.getFirstName(), person.getLastName());
        Person updatedPerson = endpointPersonService.update(person);
        logger.info("Return {}", updatedPerson);
        return updatedPerson;
    }


    @DeleteMapping(value = "/person")
    public String deletePerson(@RequestBody Person person) {
        logger.info("Request delete {} {} infos", person.getFirstName(), person.getLastName());
        String deletedPerson = endpointPersonService.delete(person);
        logger.info("Return {} {} was deleted", person.getFirstName(), person.getLastName());
        return deletedPerson;
    }
}
