package com.example.windsurfers.controller;

import com.example.windsurfers.model.WeatherLocationData;
import com.example.windsurfers.service.BestWindsurferLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class WindsurferWeatherController {
    private final BestWindsurferLocationService bestWindsurferLocationService;

    @GetMapping("best")
    public ResponseEntity<WeatherLocationData> findBestWindsurferLocation(){
        return ResponseEntity.ok(bestWindsurferLocationService.findCurrentlyBestLocation());
    }

}
