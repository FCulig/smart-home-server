package com.culig.filip.smarthome.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class ApiError {
    private String title;
    private List<String> errors;

    public ApiError() { }

    public ApiError( String title, List<String> errors) {
        super();
        this.title = title;
        this.errors = errors;
    }

    public ApiError( String title, String error) {
        super();
        this.title = title;
        errors = Arrays.asList(error);
    }
}
