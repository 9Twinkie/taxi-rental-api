package com.taxi.taxi_rental_api.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import java.time.LocalDateTime;

@Relation(collectionRelation = "users", itemRelation = "user")
public class UserResponse extends RepresentationModel<UserResponse> {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final LocalDateTime registrationDate;

    public UserResponse(Long id, String name, String email, String phone, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public LocalDateTime getRegistrationDate() { return registrationDate; }
}