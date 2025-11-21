package com.taxi.taxi_rental_api.endpoints;

import com.taxi.taxi_rental_api.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "cars", description = "API для работы с автомобилями")
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface CarApi {

    @Operation(summary = "Показать все автомобили")
    @ApiResponse(responseCode = "200", description = "Список автомобилей")
    @GetMapping("/api/cars")
    List<CarResponse> getAllCars();

    @Operation(summary = "Показать автомобиль по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобиль найден"),
            @ApiResponse(responseCode = "404", description = "Автомобиль не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/api/cars/{id}")
    CarResponse getCarById(@Parameter(description = "ID автомобиля") @PathVariable Long id);

    @Operation(summary = "Создать новый автомобиль")
    @ApiResponse(responseCode = "201", description = "Автомобиль успешно создан")
    @PostMapping(value = "/api/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CarResponse createCar(@Valid @RequestBody CarRequest request);

    @Operation(summary = "Обновить автомобиль по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобиль обновлён"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class))),
            @ApiResponse(responseCode = "404", description = "Автомобиль не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PutMapping(value = "/api/cars/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    CarResponse updateCar(
            @Parameter(description = "ID автомобиля") @PathVariable Long id,
            @Valid @RequestBody CarRequest request
    );

    @Operation(summary = "Удалить автомобиль по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Автомобиль удалён"),
            @ApiResponse(responseCode = "404", description = "Автомобиль не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @DeleteMapping("/api/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCar(@Parameter(description = "ID автомобиля") @PathVariable Long id);
}