package com.safetynet.api.service;

import com.safetynet.api.model.DTO.ListPersonsCommunityEmailAlertDTO;

public interface ICommunityEmailAlertService {
    ListPersonsCommunityEmailAlertDTO getAlert(String city);
}
