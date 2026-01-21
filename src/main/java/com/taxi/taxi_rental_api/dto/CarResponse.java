package com.taxi.taxi_rental_api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "cars", itemRelation = "car")
public class CarResponse extends RepresentationModel<CarResponse> {
    private final Long id;
    private final String model;
    private final String licensePlate;
    private final String color;
    private final Integer year;
    private final DriverResponse driver;

    public CarResponse(Long id, String model, String licensePlate, String color, Integer year, DriverResponse driver) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
        this.year = year;
        this.driver = driver;
    }

    public Long getId() { return id; }
    public String getModel() { return model; }
    public String getLicensePlate() { return licensePlate; }
    public String getColor() { return color; }
    public Integer getYear() { return year; }
    public DriverResponse getDriver() { return driver; }
}