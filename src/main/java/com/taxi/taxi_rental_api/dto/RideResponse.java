package com.taxi.taxi_rental_api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import java.time.LocalDateTime;

@Relation(collectionRelation = "rides", itemRelation = "ride")
public class RideResponse extends RepresentationModel<RideResponse> {
    private final Long id;
    private final UserResponse user;
    private final DriverResponse driver;
    private final CarResponse car;
    private final String status;
    private final LocalDateTime createdAt;
    private final LocalDateTime startedAt;
    private final LocalDateTime finishedAt;
    private final String pickupLocation;
    private final String dropoffLocation;
    private final Double cost;

    public RideResponse(
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
    ) {
        this.id = id;
        this.user = user;
        this.driver = driver;
        this.car = car;
        this.status = status;
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.cost = cost;
    }

    public Long getId() { return id; }
    public UserResponse getUser() { return user; }
    public DriverResponse getDriver() { return driver; }
    public CarResponse getCar() { return car; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public LocalDateTime getFinishedAt() { return finishedAt; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropoffLocation() { return dropoffLocation; }
    public Double getCost() { return cost; }
}