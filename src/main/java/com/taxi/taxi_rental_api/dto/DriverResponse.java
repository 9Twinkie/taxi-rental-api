package com.taxi.taxi_rental_api.dto;

public record DriverResponse(
        Long id,
        String name,
        String phone,
        String status,
        Double rating,
        String licenseNumber
) {}