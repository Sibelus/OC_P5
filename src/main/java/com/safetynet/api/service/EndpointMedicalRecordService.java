package com.safetynet.api.service;

import com.safetynet.api.model.Medicalrecord;
import com.safetynet.api.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("medical record")
public class EndpointMedicalRecordService implements IEndpointService {

    private static final Logger logger = LogManager.getLogger(EndpointMedicalRecordService.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public Object create(Object object) {
        ArrayList<Medicalrecord> allMedicalrecords = personRepository.getMedicalrecordsData();
        //Cast object to MedicalRecord class
        Medicalrecord medicalrecord = (Medicalrecord) object;
        allMedicalrecords.add(medicalrecord);
        logger.debug("Create {}", medicalrecord);
        return medicalrecord;
    }


    @Override
    public Object update(Object object) {
        //Cast object to MedicalRecord class
        Medicalrecord medicalrecord = (Medicalrecord) object;
        if(medicalrecord.getFirstName() == null || medicalrecord.getFirstName().equals("")){
            logger.error("Firstname provided is null or empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getLastName() == null || medicalrecord.getLastName().equals("")){
            logger.error("Lastname provided is null or empty");
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
    public Object delete(Object object) {
        //Cast object to MedicalRecord class
        Medicalrecord medicalrecord = (Medicalrecord) object;
        if(medicalrecord.getFirstName() == null || medicalrecord.getFirstName().equals("")){
            logger.error("Firstname provided is null or empty");
            throw new IllegalArgumentException("Firstname provided is incorrect: " + medicalrecord.getFirstName());
        }
        if(medicalrecord.getLastName() == null || medicalrecord.getLastName().equals("")){
            logger.error("Lastname provided is null or empty");
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
        return medicalrecord;
    }
}
