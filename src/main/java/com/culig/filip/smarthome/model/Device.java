package com.culig.filip.smarthome.model;

import com.culig.filip.smarthome.DTO.DeviceDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Device {
    @Id
    @GeneratedValue
    private long ID;
    private String MAC;
    private String name;

    public Device(String mac) {
        this.MAC = mac;
    }

    public Device() {
    }

    public Device(DeviceDTO dto) {
        this.ID = dto.getID();
        this.MAC = dto.getMAC();
        this.name = dto.getName();
    }
}
