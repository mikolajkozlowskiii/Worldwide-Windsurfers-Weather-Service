package com.example.windsurfers.exception;

import com.example.windsurfers.model.WeatherLocationData;

import java.util.List;

public class SuitableWindsurferLocationNotFoundException extends RuntimeException{
    public SuitableWindsurferLocationNotFoundException(List<String> locations){
        super("Any of this locations %s has suitable weather".formatted(locations));
    }
}
