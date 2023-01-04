package com.safetynet.api.controller;

import com.safetynet.api.model.Person;
import com.safetynet.api.service.IEndpointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
public class EndpointPersonController {

    private static final Logger logger = LogManager.getLogger(EndpointPersonController.class);

    @Autowired
    @Qualifier(value = "person")
    IEndpointService endpointPersonService;




    @PostMapping(value = "/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        logger.info("Request create a new {}", person);
        Person personAdded = (Person) endpointPersonService.create(person);
        if (Objects.isNull(personAdded)) {
            logger.error("Null object provided : {}", person);
            return ResponseEntity.noContent().build();
        }

        logger.info("Return {}",ResponseEntity.created(URI.create("/person")).body(personAdded));
        return ResponseEntity.created(URI.create("/person")).body(personAdded);
    }


    /*
    @PostMapping(value = "/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        logger.debug("Request create a new {}", person);
        Person personAdded = (Person) endpointPersonService.create(person);
        if (Objects.isNull(personAdded)) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();

        logger.info("Return {}",ResponseEntity.created(location).build());
        return ResponseEntity.created(location).build();
    }
    */

    @PutMapping(value = "/person")
    public Person updatePerson(@RequestBody Person person) {
        logger.info("Request update {} {} infos", person.getFirstName(), person.getLastName());
        Person updatedPerson = (Person) endpointPersonService.update(person);
        logger.info("Return {}", updatedPerson);
        return updatedPerson;
    }


    @DeleteMapping(value = "/person")
    public Person deletePerson(@RequestBody Person person) {
        logger.info("Request delete {} {} infos", person.getFirstName(), person.getLastName());
        Person deletedPerson = (Person) endpointPersonService.delete(person);
        logger.info("Return {} {} was deleted", deletedPerson.getFirstName(), deletedPerson.getLastName());
        return deletedPerson;
    }
}
