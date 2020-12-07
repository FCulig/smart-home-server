package com.culig.filip.smarthome.controller;

import com.culig.filip.smarthome.DTO.DeviceDTO;
import com.culig.filip.smarthome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public DeviceDTO registerDevice(@Valid @RequestBody DeviceDTO device) {
        return deviceService.registerDevice(device);
    }
}