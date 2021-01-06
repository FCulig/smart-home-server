package com.culig.filip.smarthome.controller;

import com.culig.filip.smarthome.DTO.TemperatureDTO;
import com.culig.filip.smarthome.service.TemperatureService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(TemperatureController.class)
public class TemperatureControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TemperatureService temperatureService;

    @Test
    @DisplayName("Test temperature inserted successfully")
    public void registerDevice_success() throws Exception {
        TemperatureDTO request = new TemperatureDTO(22.1f);
        TemperatureDTO response = request;
        response.setID(1L);

        when(temperatureService.saveTemperatureMeasurement(request)).thenReturn(response);

        this.mvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
