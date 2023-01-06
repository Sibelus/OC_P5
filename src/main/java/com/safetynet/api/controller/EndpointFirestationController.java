package com.safetynet.api.controller;

import com.safetynet.api.model.Firestation;
import com.safetynet.api.service.IEndpointFirestationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
public class EndpointFirestationController {

    private static final Logger logger = LogManager.getLogger(EndpointFirestationController.class);

    @Autowired
    IEndpointFirestationService endpointFirestationService;



    @PostMapping(value = "/firestation")
    public ResponseEntity<Firestation> createFirestation(@RequestBody Firestation firestation) {
        logger.info("Request create a new {}", firestation);
        Firestation firestationAdded = endpointFirestationService.create(firestation);
        if (Objects.isNull(firestationAdded)) {
            logger.error("Null object provided : {}", firestation);
            return ResponseEntity.noContent().build();
        }

        logger.info("Return {}",ResponseEntity.created(URI.create("/firestation")).body(firestationAdded));
        return ResponseEntity.created(URI.create("/firestation")).body(firestationAdded);
    }


    @PutMapping(value = "/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation) {
        logger.info("Request update firestation number {}", firestation.getStation());
        Firestation updatedFirestation = endpointFirestationService.update(firestation);
        logger.info("Return {}", updatedFirestation);
        return updatedFirestation;
    }


    @DeleteMapping(value = "/firestation")
    public String deleteFirestation(@RequestBody Firestation firestation) {
        logger.info("Request delete firestation number {} : {} infos", firestation.getStation(), firestation.getAddress());
        String deletedFirestation = endpointFirestationService.delete(firestation);
        logger.info("Return firestation number {} : {} was deleted", firestation.getStation(), firestation.getAddress());
        return deletedFirestation;
    }
}
