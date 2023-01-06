package com.safetynet.api.service;

import com.safetynet.api.model.Medicalrecord;

public interface IEndpointMedicalRecordService {
    Medicalrecord create(Medicalrecord medicalrecord);
    Medicalrecord update(Medicalrecord medicalrecord);
    String delete(Medicalrecord medicalrecord);
}
