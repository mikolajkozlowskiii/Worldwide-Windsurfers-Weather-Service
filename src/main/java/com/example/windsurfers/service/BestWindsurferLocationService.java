package com.example.windsurfers.service;

import com.example.windsurfers.model.WeatherLocationData;

public interface BestWindsurferLocationService {
    WeatherLocationData findCurrentlyBestLocation();
}
