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
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "rides", description = "Управление поездками")
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface RideApi {

    @Operation(summary = "Показать все поездки")
    @ApiResponse(responseCode = "200", description = "Список поездок")
    @GetMapping("/api/rides")
    CollectionModel<EntityModel<RideResponse>> getAllRides();

    @Operation(summary = "Показать поездку по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Поездка найдена"),
            @ApiResponse(responseCode = "404", description = "Поездка не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/api/rides/{id}")
    EntityModel<RideResponse> getRideById(@Parameter(description = "ID поездки") @PathVariable Long id);

    @Operation(summary = "Создать новую поездку")
    @ApiResponse(responseCode = "201", description = "Поездка успешно создана")
    @PostMapping(value = "/api/rides", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<RideResponse>> createRide(@Valid @RequestBody RideRequest request);

    @Operation(summary = "Обновить поездку по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Поездка обновлена"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class))),
            @ApiResponse(responseCode = "404", description = "Поездка не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PutMapping(value = "/api/rides/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<RideResponse>> updateRide(
            @Parameter(description = "ID поездки") @PathVariable Long id,
            @Valid @RequestBody RideRequest request
    );

    @Operation(summary = "Удалить поездку по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Поездка удалена"),
            @ApiResponse(responseCode = "404", description = "Поездка не найдена",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @DeleteMapping("/api/rides/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRide(@Parameter(description = "ID поездки") @PathVariable Long id);
}