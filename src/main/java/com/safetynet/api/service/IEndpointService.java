package com.safetynet.api.service;

import org.springframework.stereotype.Service;

@Service
public interface IEndpointService {
    Object create(Object object);
    Object update(Object object);
    Object delete(Object object);
}
