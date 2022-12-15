package com.safetynet.api.controller;

import com.safetynet.api.service.FirestationAlertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationAlertController.class)
public class FirestationAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationAlertService firestationAlertService;

    @Test
    public void testGetFirestationAlert() throws Exception {
        mockMvc.perform(get("/FirestationAlert/1"))
                .andExpect(status().isOk());
    }
}
