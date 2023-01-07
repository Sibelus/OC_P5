package com.safetynet.api.service;

import com.safetynet.api.model.Medicalrecord;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("medical record")
public class EndpointMedicalRecordService implements IEndpointMedicalRecordService {

    private static final Logger logger = LogManager.getLogger(EndpointMedicalRecordService.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public Medicalrecord create(Medicalrecord medicalrecord) {
        if(medicalrecord.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }
        if(medicalrecord.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }

        ArrayList<Medicalrecord> allMedicalrecords = personRepository.getMedicalrecordsData();
        allMedicalrecords.add(medicalrecord);
        logger.debug("Create {}", medicalrecord);
        return medicalrecord;
    }


    @Override
    public Medicalrecord update(Medicalrecord medicalrecord) {
        if(medicalrecord.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }
        if(medicalrecord.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }

        ArrayList<Medicalrecord> allMedicalrecords = personRepository.getMedicalrecordsData();
        for (Medicalrecord m : allMedicalrecords){
            if (m.getFirstName().equals(medicalrecord.getFirstName()) && m.getLastName().equals(medicalrecord.getLastName())){
                m.setBirthdate(medicalrecord.getBirthdate());
                m.setMedications(medicalrecord.getMedications());
                m.setAllergies(medicalrecord.getAllergies());
                logger.debug("Update medicalrecord {} infos", m);
            }
        }
        return medicalrecord;
    }


    @Override
    public String delete(Medicalrecord medicalrecord) {
        if(medicalrecord.getFirstName() == null){
            logger.error("Firstname provided is null");
            throw new NullPointerException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getFirstName().equals("")){
            logger.error("Firstname provided is empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getLastName() == null){
            logger.error("Lastname provided is null");
            throw new NullPointerException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }
        if(medicalrecord.getLastName().equals("")){
            logger.error("Lastname provided is empty");
            throw new IllegalArgumentException("Lastname provided is incorrect: " + medicalrecord.getLastName());
        }

        ArrayList<Medicalrecord> allMedicalrecords = personRepository.getMedicalrecordsData();
        ArrayList<Medicalrecord> newMedicalrecords = personRepository.getMedicalrecordsData();
        for (Medicalrecord m : allMedicalrecords){
            if (m.getFirstName().equals(medicalrecord.getFirstName()) && m.getLastName().equals(medicalrecord.getLastName())){
                newMedicalrecords.remove(medicalrecord);
                logger.debug("Delete {} infos", m);
            }
        }
        return "medicalrecord for " + medicalrecord.getFirstName() + " " + medicalrecord.getLastName() + " was successfully deleted";
    }
}
