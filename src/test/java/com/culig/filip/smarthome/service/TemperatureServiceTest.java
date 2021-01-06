package com.culig.filip.smarthome.service;

import com.culig.filip.smarthome.DTO.TemperatureDTO;
import com.culig.filip.smarthome.model.Device;
import com.culig.filip.smarthome.model.Temperature;
import com.culig.filip.smarthome.repository.TemperatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class TemperatureServiceTest {

    private List<Temperature> mockedTemperatureList;
    private List<TemperatureDTO> mockedTemperatureDTOList;
    private Timestamp beforeTimestamp;
    private Timestamp afterTimestamp;

    @Mock
    private TemperatureRepository temperatureRepository;

    @InjectMocks
    private TemperatureService temperatureService;

    @BeforeEach
    void setUp() {
        mockedTemperatureList = new ArrayList<>();
        mockedTemperatureList.add(new Temperature(1L, 22.2f, Timestamp.valueOf("2021-01-06 12:00:00")));
        mockedTemperatureList.add(new Temperature(2L, 13.1f, Timestamp.valueOf("2021-01-06 13:00:00")));
        mockedTemperatureList.add(new Temperature(3L, 24.6f, Timestamp.valueOf("2021-01-06 14:00:00")));

        mockedTemperatureDTOList = new ArrayList<>();
        for (Temperature t : mockedTemperatureList) {
            mockedTemperatureDTOList.add(new TemperatureDTO(t));
        }

        beforeTimestamp = Timestamp.valueOf("2021-01-06 13:30:00");
        afterTimestamp = Timestamp.valueOf("2021-01-06 12:30:00");
    }

    @Test
    @DisplayName("Should return all temperatures")
    void getAllTemperatures() {
        when(temperatureRepository.getAllTemperatures()).thenReturn(mockedTemperatureList);

        List<TemperatureDTO> result = temperatureService.getTemperatures(null, null);
        assertEquals(mockedTemperatureDTOList, result, "Temperatures don't match");
    }

    @Test
    @DisplayName("Should return temperatures before given time")
    void getBeforeTemperatures() {
        List<Temperature> returnedTemperatures = new ArrayList<>();
        List<TemperatureDTO> expected = new ArrayList<>();

        returnedTemperatures.add(mockedTemperatureList.get(0));
        expected.add(mockedTemperatureDTOList.get(0));

        when(temperatureRepository.findAllTemperaturesRecordedUntil(beforeTimestamp.toString())).thenReturn(returnedTemperatures);

        List<TemperatureDTO> result = temperatureService.getTemperatures(null, beforeTimestamp);
        assertEquals(expected, result, "Temperatures don't match");
    }

    @Test
    @DisplayName("Should return temperatures after given time")
    void getAfterTemperatures() {
        List<Temperature> returnedTemperatures = new ArrayList<>();
        List<TemperatureDTO> expected = new ArrayList<>();

        returnedTemperatures.add(mockedTemperatureList.get(2));
        expected.add(mockedTemperatureDTOList.get(2));

        when(temperatureRepository.findAllTemperaturesRecordedFrom(afterTimestamp.toString())).thenReturn(returnedTemperatures);

        List<TemperatureDTO> result = temperatureService.getTemperatures(afterTimestamp, null);
        assertEquals(expected, result, "Temperatures don't match");
    }

    @Test
    @DisplayName("Should return temperatures between given times")
    void getBetweenTemperatures() {
        List<Temperature> returnedTemperatures = new ArrayList<>();
        List<TemperatureDTO> expected = new ArrayList<>();

        returnedTemperatures.add(mockedTemperatureList.get(1));
        expected.add(mockedTemperatureDTOList.get(1));

        when(temperatureRepository.findAllTemperaturesRecordedBetween(afterTimestamp.toString(), beforeTimestamp.toString())).thenReturn(returnedTemperatures);

        List<TemperatureDTO> result = temperatureService.getTemperatures(afterTimestamp, beforeTimestamp);
        assertEquals(expected, result, "Temperatures don't match");
    }

    @Test
    @DisplayName("Should call repository to insert temperature measurement")
    void saveTemperatureMeasurement() {
        Temperature input = new Temperature(22.2f);
        TemperatureDTO inputDTO = new TemperatureDTO(input);

        when(temperatureRepository.save(any(Temperature.class))).thenReturn(mockedTemperatureList.get(0));

        TemperatureDTO result = temperatureService.saveTemperatureMeasurement(inputDTO);
        assertEquals(mockedTemperatureDTOList.get(0), result, "Temperatures don't match");
    }
}