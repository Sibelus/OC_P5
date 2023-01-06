package com.safetynet.api.controller;

import com.safetynet.api.model.Medicalrecord;
import com.safetynet.api.service.IEndpointMedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
public class EndpointMedicalRecordController {

    private static final Logger logger = LogManager.getLogger(EndpointMedicalRecordController.class);

    @Autowired
    IEndpointMedicalRecordService endpointMedicalRecordService;



    @PostMapping(value = "/medicalRecord")
    public ResponseEntity<Medicalrecord> createMedicalRecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request create a new {}", medicalrecord);
        Medicalrecord medicalRecordAdded = endpointMedicalRecordService.create(medicalrecord);
        if (Objects.isNull(medicalRecordAdded)) {
            logger.error("Null object provided : {}", medicalRecordAdded);
            return ResponseEntity.noContent().build();
        }

        logger.info("Return {}",ResponseEntity.created(URI.create("/medicalRecord")).body(medicalRecordAdded));
        return ResponseEntity.created(URI.create("/medicalRecord")).body(medicalRecordAdded);
    }


    @PutMapping(value = "/medicalRecord")
    public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request update {} {}'s medical record", medicalrecord.getFirstName(), medicalrecord.getLastName());
        Medicalrecord updatedMedicalrecord = endpointMedicalRecordService.update(medicalrecord);
        logger.info("Return {}", updatedMedicalrecord);
        return updatedMedicalrecord;
    }


    @DeleteMapping(value = "/medicalRecord")
    public String deleteMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request delete {} {}'s medical record ", medicalrecord.getFirstName(), medicalrecord.getLastName());
        String deletedMedicalrecord = endpointMedicalRecordService.delete(medicalrecord);
        logger.info("Return {} {}'s medical record was deleted", medicalrecord.getFirstName(), medicalrecord.getLastName());
        return deletedMedicalrecord;
    }
}
