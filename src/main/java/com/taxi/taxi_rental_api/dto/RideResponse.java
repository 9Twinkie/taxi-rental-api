package com.taxi.taxi_rental_api.dto;

import java.time.LocalDateTime;

public record RideResponse(
        Long id,
        UserResponse user,
        DriverResponse driver,
        CarResponse car,
        String status,
        LocalDateTime createdAt,
        LocalDateTime startedAt,
        LocalDateTime finishedAt,
        String pickupLocation,
        String dropoffLocation,
        Double cost
) {}