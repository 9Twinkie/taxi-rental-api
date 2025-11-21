package com.taxi.taxi_rental_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DriverRequest(
        @NotBlank String name,
        @NotBlank String phone,
        @NotBlank String licenseNumber
) {}