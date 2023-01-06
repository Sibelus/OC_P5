package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListePersonsPhoneAlertDTO;

public interface IPhoneAlertService {
    ListePersonsPhoneAlertDTO getAlert(int firestationNumber);
}
