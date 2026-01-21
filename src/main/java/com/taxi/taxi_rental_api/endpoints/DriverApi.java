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

@Tag(name = "drivers", description = "Управление водителями")
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface DriverApi {

    @Operation(summary = "Показать всех водителей")
    @ApiResponse(responseCode = "200", description = "Список водителей")
    @GetMapping("/api/drivers")
    CollectionModel<EntityModel<DriverResponse>> getAllDrivers();

    @Operation(summary = "Показать водителя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Водитель найден"),
            @ApiResponse(responseCode = "404", description = "Водитель не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/api/drivers/{id}")
    EntityModel<DriverResponse> getDriverById(@Parameter(description = "ID водителя") @PathVariable Long id);

    @Operation(summary = "Создать нового водителя")
    @ApiResponse(responseCode = "201", description = "Водитель успешно создан")
    @PostMapping(value = "/api/drivers", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<DriverResponse>> createDriver(@Valid @RequestBody DriverRequest request);

    @Operation(summary = "Обновить водителя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Водитель обновлён"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class))),
            @ApiResponse(responseCode = "404", description = "Водитель не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PutMapping(value = "/api/drivers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<DriverResponse>> updateDriver(
            @Parameter(description = "ID водителя") @PathVariable Long id,
            @Valid @RequestBody DriverRequest request
    );

    @Operation(summary = "Удалить водителя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Водитель удалён"),
            @ApiResponse(responseCode = "404", description = "Водитель не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @DeleteMapping("/api/drivers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDriver(@Parameter(description = "ID водителя") @PathVariable Long id);
}