package uk.co.which.forensicsapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ForensicsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAllDirections() throws Exception {
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/directions"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllDirections_should_return_401_while_using_un_auth_email() throws Exception {
        mockMvc.perform(get("/api/v1/u@gmail.com/directions"))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldReturn_401_All_Directions_should_return_while_using_in_valid_email() throws Exception {
        mockMvc.perform(get("/api/v1/invalid@email.com/directions"))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void should_b2_401_when_invalid_format_email() throws Exception {
        mockMvc.perform(get("/api/v1/invalid@email.com/location/1/2"))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void should_be_404_when_invalid_uri() throws Exception {
        mockMvc.perform(get("/api/v2/invalid@email.com/location/1/2"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void should_be_400_when_invalid_path_params() throws Exception {
        mockMvc.perform(get("/api/v1/invalid@email.com/location/1/'2'"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void should_be_403_more_than_5_guess() throws Exception {
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/directions"))
                .andDo(print()).andExpect(status().isOk());
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"));
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"));
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"));
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"));
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"));
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void should_400_when_directly_call_location_api() throws Exception {
        mockMvc.perform(get("/api/v1/uppalavijay@gmail.com/location/1/5"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

}