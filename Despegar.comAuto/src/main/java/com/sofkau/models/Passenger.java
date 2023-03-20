package com.sofkau.models;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class Passenger {
    private static final Faker faker = new Faker();
    private String name = faker.name().firstName();
    private String lName = faker.name().lastName();
}
