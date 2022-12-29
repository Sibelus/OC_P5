package com.safetynet.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.model.Person;
import com.safetynet.api.service.IEndpointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EndpointPersonController.class)
public class EndpointControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    @Qualifier(value = "person")
    private IEndpointService iEndpointService;


    /*
    @Test
    public void testEndpointPersonController_CreateNewPerson() throws Exception {

        Person person = new Person();

        mockMvc.perform(post("/person").content(asJsonString(person)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }*/

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
