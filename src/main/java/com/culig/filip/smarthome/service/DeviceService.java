package com.culig.filip.smarthome.service;

import com.culig.filip.smarthome.DTO.DeviceDTO;
import com.culig.filip.smarthome.model.Device;
import com.culig.filip.smarthome.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDTO registerDevice(DeviceDTO deviceDTO) {
        if (deviceRepository.findDeviceWithMAC(deviceDTO.getMAC()) == null) {
            Device device = new Device(deviceDTO.getMAC());
            deviceDTO = new DeviceDTO(deviceRepository.save(device));
        }
        return deviceDTO;
    }
}
