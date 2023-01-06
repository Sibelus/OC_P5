package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsPersonInfoAlertDTO;

public interface IPersonInfoAlertService {
    ListPersonsPersonInfoAlertDTO getAlert(String firstName, String lastName);
}
