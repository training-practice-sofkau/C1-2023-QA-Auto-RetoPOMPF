package com.sofkau.models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsiblePassenger extends Passenger {
    private static final Faker faker = new Faker();
    private String email = String.format("%s@gmail.com", getName());
    private String number = faker.number().digits(10);
    private String cc = faker.number().digits(10);
    private String address = faker.address().fullAddress();
}