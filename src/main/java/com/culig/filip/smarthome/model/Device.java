package com.culig.filip.smarthome.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
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
}
