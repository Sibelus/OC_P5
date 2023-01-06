package com.safetynet.api.service;

import com.safetynet.api.model.Person;

public interface IEndpointPersonService {
    Person create(Person person);
    Person update(Person person);
    String delete(Person person);
}
