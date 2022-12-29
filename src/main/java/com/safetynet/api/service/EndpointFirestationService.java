package com.safetynet.api.service;

import com.safetynet.api.model.Firestation;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component("firestation")
public class EndpointFirestationService implements IEndpointService {

    private static final Logger logger = LogManager.getLogger(EndpointFirestationService.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public Object create(Object object) {
        ArrayList<Firestation> allFirestations = personRepository.getFirestationsData();
        //Cast object to firestation class
        Firestation firestation = (Firestation) object;
        allFirestations.add(firestation);
        logger.debug("Create firestation number {} : {}", firestation.getStation(), firestation.getAddress());
        return firestation;
    }

    @Override
    public Object update(Object object) {
        //Cast object to firestation class
        Firestation firestation = (Firestation) object;

        ArrayList<Firestation> allFirestations = personRepository.getFirestationsData();
        for (Firestation f : allFirestations) {
            if (Objects.equals(f.getAddress(), firestation.getAddress())) {
                f.setStation(firestation.getStation());
                logger.debug("Update firestation number {}", f.getStation());
            }
        }
        return firestation;
    }

    @Override
    public Object delete(Object object) {
        //Cast object to firestation class
        Firestation firestation = (Firestation) object;
        ArrayList<Firestation> allFirestations = personRepository.getFirestationsData();
        ArrayList<Firestation> newFirestationsLIst = personRepository.getFirestationsData();

        for (Firestation f : allFirestations){
            if (Objects.equals(f.getStation(), firestation.getStation())){
                newFirestationsLIst.remove(f);
                logger.debug("Delete firestation number {} for address mapping {}", f.getStation(), f.getAddress());
            }
            if (Objects.equals(f.getAddress(), firestation.getAddress())){
                newFirestationsLIst.remove(f);
                logger.debug("Delete address mapping {} for firestation number {}", f.getAddress(), f.getStation());
            }
        }
        return firestation;
    }
}