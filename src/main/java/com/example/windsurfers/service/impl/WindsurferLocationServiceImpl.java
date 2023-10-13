package com.example.windsurfers.service.impl;

import com.example.windsurfers.model.WindsurferLocation;
import com.example.windsurfers.service.WindsurferLocationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WindsurferLocationServiceImpl implements WindsurferLocationService {
    @Override
    public List<WindsurferLocation> getAllLocations() {
        return Arrays.stream(WindsurferLocation.values()).toList();
    }
}
