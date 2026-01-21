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

@Tag(name = "users", description = "Управление пользователями (пассажирами)")
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface UserApi {

    @Operation(summary = "Показать всех пользователей")
    @ApiResponse(responseCode = "200", description = "Список пользователей")
    @GetMapping("/api/users")
    CollectionModel<EntityModel<UserResponse>> getAllUsers();

    @Operation(summary = "Показать пользователя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @GetMapping("/api/users/{id}")
    EntityModel<UserResponse> getUserById(@Parameter(description = "ID пользователя") @PathVariable Long id);

    @Operation(summary = "Создать нового пользователя")
    @ApiResponse(responseCode = "201", description = "Пользователь успешно создан")
    @PostMapping(value = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<UserResponse>> createUser(@Valid @RequestBody UserRequest request);

    @Operation(summary = "Обновить пользователя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Пользователь обновлён"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class))),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @PutMapping(value = "/api/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<UserResponse>> updateUser(
            @Parameter(description = "ID пользователя") @PathVariable Long id,
            @Valid @RequestBody UserRequest request
    );

    @Operation(summary = "Удалить пользователя по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Пользователь удалён"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = @Content(schema = @Schema(implementation = StatusResponse.class)))
    })
    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@Parameter(description = "ID пользователя") @PathVariable Long id);
}