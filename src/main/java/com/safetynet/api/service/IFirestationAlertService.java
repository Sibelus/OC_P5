package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFirestationAlertDTO;

public interface IFirestationAlertService {
    ListPersonsFirestationAlertDTO getAlert(int firestationNumber);
}
