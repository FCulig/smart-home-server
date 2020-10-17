package com.culig.filip.smarthome.service;

import com.culig.filip.smarthome.DTO.TemperatureDTO;
import com.culig.filip.smarthome.model.Temperature;
import com.culig.filip.smarthome.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public List<TemperatureDTO> getTemperatures(Timestamp from, Timestamp until) {
        if (from != null && until != null) {
            return convertTemperatureListToTemperatureDTOList(temperatureRepository.findAllTemperaturesRecordedBetween(from.toString(), until.toString()));
        } else if (from != null) {
            return convertTemperatureListToTemperatureDTOList(temperatureRepository.findAllTemperaturesRecordedFrom(from.toString()));
        } else if (until != null) {
            return convertTemperatureListToTemperatureDTOList(temperatureRepository.findAllTemperaturesRecordedUntil(until.toString()));
        } else {
            return convertTemperatureListToTemperatureDTOList(temperatureRepository.getAllTemperatures());
        }
    }

    public TemperatureDTO saveTemperatureMeasurement(TemperatureDTO temperatureDTO) {
        return new TemperatureDTO(temperatureRepository.save(new Temperature(temperatureDTO.getTemperature())));
    }

    public List<TemperatureDTO> convertTemperatureListToTemperatureDTOList(List<Temperature> temperatures) {
        List<TemperatureDTO> dtos = new ArrayList<>();
        for (Temperature t : temperatures) {
            dtos.add(new TemperatureDTO(t));
        }

        return dtos;
    }
}
