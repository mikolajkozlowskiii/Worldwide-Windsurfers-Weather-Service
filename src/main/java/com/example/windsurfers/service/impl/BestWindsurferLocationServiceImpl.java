package com.example.windsurfers.service.impl;

import com.example.windsurfers.exception.SuitableWindsurferLocationNotFoundException;
import com.example.windsurfers.model.WeatherApiResponse;
import com.example.windsurfers.model.WeatherLocationData;
import com.example.windsurfers.service.BestWindsurferLocationService;
import com.example.windsurfers.service.WeatherLocationService;
import com.example.windsurfers.service.WindsurferLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class BestWindsurferLocationServiceImpl implements BestWindsurferLocationService {
    private final WindsurferLocationService windsurferLocationService;
    private final WeatherLocationService weatherLocationService;

    @Override
    public WeatherLocationData findCurrentlyBestLocation() {
        final List<WeatherLocationData> locationsWeatherData = getAllLocationsWeatherData();

        return findBestLocationForSurfing(locationsWeatherData);
    }

    private WeatherLocationData findBestLocationForSurfing(List<WeatherLocationData> locationsWeatherData) {
        return locationsWeatherData
                .stream()
                .filter(windCriteria())
                .filter(temperatureCriteria())
                .max(Comparator.comparing(selectionCriteria()))
                .orElseThrow(() -> new SuitableWindsurferLocationNotFoundException(
                        locationsWeatherData
                                .stream()
                                .map(WeatherLocationData::getCityName)
                                .toList()
                        )
                );
    }

    private List<WeatherLocationData> getAllLocationsWeatherData() {
        return windsurferLocationService.getAllLocations()
                .stream()
                .map(weatherLocationService::getWeatherByLocation)
                .map(getWeatherData())
                .toList();
    }

    private Function<WeatherLocationData, Double> selectionCriteria() {
        return s -> s.getWindSpeedInMs() * 3 + s.getTemperatureInCelsius();
    }

    private Predicate<WeatherLocationData> temperatureCriteria() {
        return s -> !Objects.isNull(s.getTemperatureInCelsius()) && s.getTemperatureInCelsius() > 5 && s.getTemperatureInCelsius() < 35;
    }

    private Predicate<WeatherLocationData> windCriteria() {
        return s -> !Objects.isNull(s.getWindSpeedInMs()) && s.getWindSpeedInMs() > 5 && s.getWindSpeedInMs() < 18;
    }

    private Function<WeatherApiResponse, WeatherLocationData> getWeatherData() {
        return s -> s.getData().get(0);
    }
}
