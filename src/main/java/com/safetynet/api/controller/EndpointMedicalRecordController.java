package com.safetynet.api.controller;

import com.safetynet.api.model.Medicalrecord;
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
public class EndpointMedicalRecordController {

    private static final Logger logger = LogManager.getLogger(EndpointMedicalRecordController.class);

    @Autowired
    @Qualifier(value = "medical record")
    IEndpointService endpointMedicalRecordService;



    @PostMapping(value = "/medicalRecord")
    public ResponseEntity<Medicalrecord> createMedicalRecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request create a new {}", medicalrecord);
        Medicalrecord medicalRecordAdded = (Medicalrecord) endpointMedicalRecordService.create(medicalrecord);
        if (Objects.isNull(medicalRecordAdded)) {
            logger.error("Null object provided : {}", medicalrecord);
            return ResponseEntity.noContent().build();
        }

        logger.info("Return {}",ResponseEntity.created(URI.create("/medicalRecord")).body(medicalRecordAdded));
        return ResponseEntity.created(URI.create("/medicalRecord")).body(medicalRecordAdded);
    }


    @PutMapping(value = "/medicalRecord")
    public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request update {} {}'s medical record", medicalrecord.getFirstName(), medicalrecord.getLastName());
        Medicalrecord updatedMedicalrecord = (Medicalrecord) endpointMedicalRecordService.update(medicalrecord);
        logger.info("Return {}", updatedMedicalrecord);
        return updatedMedicalrecord;
    }


    @DeleteMapping(value = "/medicalRecord")
    public Medicalrecord deleteMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("Request delete {} {}'s medical record ", medicalrecord.getFirstName(), medicalrecord.getLastName());
        Medicalrecord deletedMedicalrecord = (Medicalrecord) endpointMedicalRecordService.delete(medicalrecord);
        logger.info("Return {} {}'s medical record was deleted", deletedMedicalrecord.getFirstName(), deletedMedicalrecord.getLastName());
        return deletedMedicalrecord;
    }
}
