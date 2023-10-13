package com.example.windsurfers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherLocationData {
    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("temp")
    private Double temperatureInCelsius;

    @JsonProperty("wind_spd")
    private Double windSpeedInMs;
}
