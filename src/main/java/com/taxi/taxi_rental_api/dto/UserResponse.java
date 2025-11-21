package com.taxi.taxi_rental_api.dto;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        String phone,
        LocalDateTime registrationDate
) {}