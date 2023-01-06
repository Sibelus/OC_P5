package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsFloodAlertDTO;

import java.util.List;

public interface IFloodAlertService {
    ListPersonsFloodAlertDTO getAlert(List<Integer> listFirestationNumber);
}
