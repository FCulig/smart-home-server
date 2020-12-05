package com.culig.filip.smarthome.controller;

import com.culig.filip.smarthome.DTO.DeviceDTO;
import com.culig.filip.smarthome.model.Device;
import com.culig.filip.smarthome.service.DeviceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeviceControllerTest {

    @Autowired
    private DeviceController deviceController;

    @Mock
    private DeviceService deviceService;

    @Test
    @DisplayName("Test register device successfully")
    public void registerDevice() throws Exception {
        DeviceDTO request = new DeviceDTO(new Device("MAC-ADDRESS"));

        DeviceDTO response = request;
        response.setID(1L);

        when(deviceService.registerDevice(request)).thenReturn(response);

        assertThat(deviceService.registerDevice(request)).isEqualTo(response);
    }
}