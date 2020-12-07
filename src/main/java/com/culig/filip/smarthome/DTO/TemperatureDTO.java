package com.culig.filip.smarthome.DTO;

import com.culig.filip.smarthome.model.Temperature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TemperatureDTO {
    private long ID;

    private float temperature;

    private Timestamp recordedAt;

    public TemperatureDTO(Temperature temperature) {
        this.temperature = temperature.getTemperature();
        this.ID = temperature.getID();
        this.recordedAt = temperature.getRecordedAt();
    }

    public TemperatureDTO(float temperature) {
        this.temperature = temperature;
    }

    public TemperatureDTO() {
    }
}
