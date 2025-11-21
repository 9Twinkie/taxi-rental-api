package com.taxi.taxi_rental_api.dto;

import jakarta.validation.constraints.NotNull;

public record RideRequest(
        @NotNull Long userId,
        @NotNull Long driverId,
        @NotNull Long carId,
        @NotNull String pickupLocation,
        @NotNull String dropoffLocation
) {}