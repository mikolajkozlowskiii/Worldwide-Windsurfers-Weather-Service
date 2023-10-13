package com.example.windsurfers.service.impl;

import com.example.windsurfers.model.WeatherApiResponse;
import com.example.windsurfers.model.WindsurferLocation;
import com.example.windsurfers.service.WeatherLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherLocationServiceImpl implements WeatherLocationService {
    private final WebClient webClient;
    @Override
    public WeatherApiResponse getWeatherByLocation(WindsurferLocation location) {
        return webClient
                .get()
                .uri(
                        uriBuilder -> uriBuilder
                                .queryParam("city", location.getCityName())
                                .queryParam("country", location.getCountryName())
                                .build()
                )
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .block();
    }
}
