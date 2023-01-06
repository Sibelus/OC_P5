package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsChildAlertDTO;

public interface IChildAlertService {
    ListPersonsChildAlertDTO getAlert(String address);
}
