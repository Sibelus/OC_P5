package com.safetynet.api.service;

import com.safetynet.api.model.Firestation;

public interface IEndpointFirestationService {
    Firestation create(Firestation firestation);
    Firestation update(Firestation firestation);
    String delete(Firestation firestation);
}
