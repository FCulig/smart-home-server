package com.culig.filip.smarthome.service;

import com.culig.filip.smarthome.DTO.DeviceDTO;
import com.culig.filip.smarthome.model.Device;
import com.culig.filip.smarthome.repository.DeviceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class DeviceServiceTest {

    @Mock
    DeviceRepository deviceRepository;

    @InjectMocks
    DeviceService deviceService;

    @Test
    @DisplayName("Should return existing device")
    void registerExistingDevice() {
        DeviceDTO deviceDTO = new DeviceDTO(1L, "EXISTING-MAC");

        when(deviceRepository.findDeviceWithMAC(deviceDTO.getMAC())).thenReturn(new Device(deviceDTO));

        assertEquals(deviceDTO, deviceService.registerDevice(deviceDTO), "Devices don't match");
    }

    @Test
    @DisplayName("Should register new device")
    void registerNewDevice() {
        DeviceDTO deviceDTO = new DeviceDTO("NEW-MAC");
        Device device = new Device(deviceDTO);

        DeviceDTO expectedDeviceDTO = deviceDTO;
        expectedDeviceDTO.setID(1L);
        Device expectedDevice = new Device(expectedDeviceDTO);

        when(deviceRepository.findDeviceWithMAC(deviceDTO.getMAC())).thenReturn(null);
        when(deviceRepository.save(device)).thenReturn(expectedDevice);

        assertEquals(expectedDeviceDTO, deviceService.registerDevice(deviceDTO), "Devices don't match");
    }
}