package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFireAlertDTO;

public interface IFireAlertService {
    ListPersonsFireAlertDTO getAlert(String address);
}
