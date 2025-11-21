package com.taxi.taxi_rental_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarRequest(
        @NotBlank String model,
        @NotBlank String licensePlate,
        @NotBlank String color,
        @NotNull Integer year,
        @NotNull Long driverId
) {}