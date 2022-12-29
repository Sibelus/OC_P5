package com.safetynet.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.model.Firestation;
import com.safetynet.api.model.Medicalrecord;
import com.safetynet.api.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EndpointControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    //Method that convert object to json
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /* ---------- POST ----------*/
    @Test
    public void integrationTest_EndpointPersonController_CreateNewPerson() throws Exception{
        Person person = new Person();
        person.setFirstName("Moctar");

        mockMvc.perform(post("/person").content(asJsonString(person)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is("Moctar")));
    }

    @Test
    public void integrationTest_EndpointFirestationController_CreateNewFirestation() throws Exception{
        Firestation firestation = new Firestation();
        firestation.setAddress("221 B Backer street");


        mockMvc.perform(post("/firestation").content(asJsonString(firestation)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.address", is("221 B Backer street")));
    }

    @Test
    public void integrationTest_EndpointMedicalrecordController_CreateNewMedicalrecord() throws Exception{
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setBirthdate("12/12/2012");


        mockMvc.perform(post("/medicalRecord").content(asJsonString(medicalrecord)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.birthdate", is("12/12/2012")));
    }



    /* ---------- PUT ----------*/
    @Test
    public void integrationTest_EndpointPersonController_UpdatePerson() throws Exception{
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setEmail("newMail@email.com");

        mockMvc.perform(put("/person").content(asJsonString(person)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("newMail@email.com")));
    }

    @Test
    public void integrationTest_EndpointFirestationController_UpdateFirestation() throws Exception{
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation(13);

        mockMvc.perform(put("/firestation").content(asJsonString(firestation)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.station", is(13)));
    }

    @Test
    public void integrationTest_EndpointMedicalrecordController_UpdateMedicalrecord() throws Exception{
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("John");
        medicalrecord.setLastName("Boyd");
        medicalrecord.setBirthdate("32/12/1212");

        mockMvc.perform(put("/medicalRecord").content(asJsonString(medicalrecord)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.birthdate", is("32/12/1212")));
    }



    /* ---------- DELETE ----------*/
    @Test
    public void integrationTest_EndpointPersonController_DeletePerson() throws Exception{
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");

        mockMvc.perform(delete("/person").content(asJsonString(person)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    @Test
    public void integrationTest_EndpointFirestationController_DeleteFirestationByNumber() throws Exception{
        Firestation firestation = new Firestation();
        firestation.setStation(3);

        mockMvc.perform(delete("/firestation").content(asJsonString(firestation)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.station", is(3)));
    }

    @Test
    public void integrationTest_EndpointFirestationController_DeleteFirestationByAddress() throws Exception{
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");

        mockMvc.perform(delete("/firestation").content(asJsonString(firestation)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address", is("1509 Culver St")));
    }

    @Test
    public void integrationTest_EndpointMedicalrecordController_DeleteMedicalrecord() throws Exception{
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("John");
        medicalrecord.setLastName("Boyd");
        medicalrecord.setBirthdate("32/12/1212");

        mockMvc.perform(delete("/medicalRecord").content(asJsonString(medicalrecord)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("John")));
    }
}
