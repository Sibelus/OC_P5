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
public class AlertControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void integrationTest_GetFirestationAlert() throws Exception{
        mockMvc.perform(get("/FirestationAlert/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.persons[0].firstName", is("Peter")));
    }

    @Test
    public void integrationTest_GetChildAlert() throws Exception{
        mockMvc.perform(get("/ChildAlert/1509 Culver St"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.childrenAndTheirFamily[0].firstName", is("Tenley")));
    }
}
