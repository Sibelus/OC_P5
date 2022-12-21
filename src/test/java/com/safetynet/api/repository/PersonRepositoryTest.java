package com.safetynet.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testAggregateData() throws IOException {
        //GIVEN

        //WHEN
        ArrayList<Person> allPersons = personRepository.getPersonsAggregatedData();

        //THEN
        Assertions.assertEquals(3 , allPersons.get(0).getStation());
        Assertions.assertEquals("03/06/1984", allPersons.get(0).getBirthdate());
        //Assertions.assertEquals(allPersons.get(0).getMedications(), new String[]{"honey", "lemon"});
        //Assertions.assertEquals(allPersons.get(0).getAllergies(), new String[]{"milk"});
    }
}
