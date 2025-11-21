package com.taxi.taxi_rental_api.dto;


public record CarResponse(
        Long id,
        String model,
        String licensePlate,
        String color,
        Integer year,
        DriverResponse driver
) {}