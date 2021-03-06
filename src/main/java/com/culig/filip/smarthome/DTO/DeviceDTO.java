package com.culig.filip.smarthome.DTO;

import com.culig.filip.smarthome.model.Device;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DeviceDTO {
    private long ID;
    private String MAC;
    private String name;

    public DeviceDTO(Device device) {
        this.ID = device.getID();
        this.MAC = device.getMAC();
        this.name = device.getName();
    }

    public DeviceDTO() {
    }

    public DeviceDTO(long l, String mac) {
        this.ID = l;
        this.MAC = mac;
    }
}
