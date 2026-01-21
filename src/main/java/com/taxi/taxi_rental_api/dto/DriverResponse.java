package com.taxi.taxi_rental_api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "drivers", itemRelation = "driver")
public class DriverResponse extends RepresentationModel<DriverResponse> {
    private final Long id;
    private final String name;
    private final String phone;
    private final String status;
    private final Double rating;
    private final String licenseNumber;

    public DriverResponse(Long id, String name, String phone, String status, Double rating, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.rating = rating;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getStatus() { return status; }
    public Double getRating() { return rating; }
    public String getLicenseNumber() { return licenseNumber; }
}