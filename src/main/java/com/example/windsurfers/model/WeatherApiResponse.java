package com.example.windsurfers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherApiResponse {
    private int count;
    private List<WeatherLocationData> data;
}
