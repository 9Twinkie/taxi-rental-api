package com.taxi.taxi_rental_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotBlank(message = "Имя обязательно")
        String name,

        @Email(message = "Некорректный email")
        String email,

        @NotBlank(message = "Телефон обязателен")
        String phone,

        @NotBlank(message = "Пароль обязателен")
        String password
) {}