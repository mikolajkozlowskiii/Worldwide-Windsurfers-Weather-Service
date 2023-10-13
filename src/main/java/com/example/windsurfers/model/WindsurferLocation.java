package com.example.windsurfers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WindsurferLocation {
    JASTARNIA("Jastarnia", "Poland"),
    BRIDGETOWN("Bridgetown", "Barbados"),
    FORTALEZA("Fortaleza", "Brazil"),
    PISSOURI("Pissouri", "Cyprus"),
    LEMORNE("Le Morne", "Mauritius");
    private final String cityName;
    private final String countryName;
}