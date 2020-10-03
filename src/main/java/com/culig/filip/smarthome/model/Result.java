package com.culig.filip.smarthome.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    private Boolean isSuccessful;
    private String errorDescription;
}
