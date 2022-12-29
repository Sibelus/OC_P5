package com.safetynet.api.controller;

import com.safetynet.api.model.Firestation;
import com.safetynet.api.service.IEndpointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
public class EndpointFirestationController {

    private static final Logger logger = LogManager.getLogger(EndpointFirestationController.class);

    @Autowired
    @Qualifier(value = "firestation")
    IEndpointService endpointFirestationService;



    @PostMapping(value = "/firestation")
    public ResponseEntity<Firestation> createFirestation(@RequestBody Firestation firestation) {
        logger.debug("Request create a new {}", firestation);
        Firestation firestationAdded = (Firestation) endpointFirestationService.create(firestation);
        if (Objects.isNull(firestationAdded)) {
            return ResponseEntity.noContent().build();
        }

        logger.debug("Return {}",ResponseEntity.created(URI.create("/firestation")).body(firestationAdded));
        return ResponseEntity.created(URI.create("/firestation")).body(firestationAdded);
    }


    @PutMapping(value = "/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation) {
        logger.debug("Request update firestation number {}", firestation.getStation());
        Firestation updatedFirestation = (Firestation) endpointFirestationService.update(firestation);
        logger.debug("Return {}", updatedFirestation);
        return updatedFirestation;
    }


    @DeleteMapping(value = "/firestation")
    public Firestation deleteFirestation(@RequestBody Firestation firestation) {
        logger.debug("Request delete firestation number {} : {} infos", firestation.getStation(), firestation.getAddress());
        Firestation deletedFirestation = (Firestation) endpointFirestationService.delete(firestation);
        logger.debug("Return firestation number {} : {} was deleted", deletedFirestation.getStation(), deletedFirestation.getAddress());
        return deletedFirestation;
    }
}