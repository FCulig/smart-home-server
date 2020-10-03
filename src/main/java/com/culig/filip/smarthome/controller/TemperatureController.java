package com.culig.filip.smarthome.controller;

import com.culig.filip.smarthome.DTO.TemperatureDTO;
import com.culig.filip.smarthome.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @PostMapping
    public TemperatureDTO saveTemperatureReading(@RequestBody TemperatureDTO temperature) {
        return temperatureService.saveTemperatureMeasurement(temperature);
    }

    @GetMapping
    public List<TemperatureDTO> getTemperatures(@Nullable @RequestParam("from") Timestamp from,@Nullable @RequestParam("until") Timestamp until) {
        return temperatureService.getTemperatures(from, until);
    }
}
