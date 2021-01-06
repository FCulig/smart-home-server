package com.culig.filip.smarthome.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Temperature {
    @Id
    @GeneratedValue
    private long ID;
    private float temperature;
    private Timestamp recordedAt;

    public Temperature() {
        this.recordedAt = new Timestamp(System.currentTimeMillis());
    }

    public Temperature(float temperature) {
        this.temperature = temperature;
        this.recordedAt = new Timestamp(System.currentTimeMillis());
    }
}
