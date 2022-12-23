package com.safetynet.api.controller;

import com.safetynet.api.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {FirestationAlertController.class,
        ChildAlertController.class,
        PhoneAlertController.class,
        FireAlertController.class,
        FloodAlertController.class,
        PersonInfoController.class})
public class AlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationAlertService firestationAlertService;
    @MockBean
    private ChildAlertService childAlertService;
    @MockBean
    private PhoneAlertService phoneAlertService;
    @MockBean
    private FireAlertService fireAlertService;
    @MockBean
    private FloodAlertService floodAlertService;
    @MockBean
    private PersonInfoAlertService personInfoAlertService;


    @Test
    public void testGetFirestationAlert() throws Exception {
        mockMvc.perform(get("/firestation/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetChildAlert() throws Exception{
        mockMvc.perform(get("/childAlert/1509 Culver St"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPhoneAlert() throws Exception{
        mockMvc.perform(get("/phoneAlert/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFireAlert() throws Exception{
        mockMvc.perform(get("/fire/1509 Culver St"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFloodAlert() throws Exception{
        mockMvc.perform(get("/flood/stations/1,2,3"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPersonInfoAlert() throws Exception{
        mockMvc.perform(get("/personInfo/John,Boyd"))
                .andExpect(status().isOk());
    }
}
