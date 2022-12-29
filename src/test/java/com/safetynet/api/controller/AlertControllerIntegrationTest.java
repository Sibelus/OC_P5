package com.safetynet.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlertControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void integrationTest_GetFirestationAlert() throws Exception{
        mockMvc.perform(get("/firestation/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.persons[0].firstName", is("Peter")));
    }

    @Test
    public void integrationTest_GetChildAlert() throws Exception{
        mockMvc.perform(get("/childAlert/1509 Culver St"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.childrenAndTheirFamily[0].firstName", is("Tenley")));
    }

    @Test
    public void integrationTest_GetPhoneALert() throws Exception{
        mockMvc.perform(get("/phoneAlert/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phoneAlertList[0].phone", is("841-874-6512")));
    }

    @Test
    public void integrationTest_GetFireALert() throws Exception{
        mockMvc.perform(get("/fire/1509 Culver St"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firestationNumber", is(3)))
                .andExpect(jsonPath("$.persons[0].lastName", is("Boyd")));
    }

    @Test
    public void integrationTest_GetFloodAlert() throws Exception{
        mockMvc.perform(get("/flood/stations/1,2,3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.persons[0].address", is("1509 Culver St")));
    }

    @Test
    public void integrationTest_GetPersonInfoAlert() throws Exception{
        mockMvc.perform(get("/personInfo/John,Boyd"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.persons[0].email", is("jaboyd@email.com")));
    }

    @Test
    public void integrationTest_GetCommunityEmailAlert() throws Exception{
        mockMvc.perform(get("/communityEmail/Culver"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.communityEmailAlertList[0].email", is("jaboyd@email.com")));
    }
}
