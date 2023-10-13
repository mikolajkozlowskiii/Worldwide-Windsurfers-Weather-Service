package com.example.windsurfers.service;

import com.example.windsurfers.model.WeatherApiResponse;import com.example.windsurfers.model.WindsurferLocation;

public interface WeatherLocationService {
    WeatherApiResponse getWeatherByLocation(WindsurferLocation location);
}
