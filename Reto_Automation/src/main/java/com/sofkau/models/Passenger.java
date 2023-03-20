package com.sofkau.models;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Passenger {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String gender;
    private String documentNumber;
    private String phoneNumber;

    public Passenger(String firstName, String lastName, String birthdate, String gender,
                     String documentNumber, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
    }

    public Passenger() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static String generarFecha() {
        Faker faker = new Faker();
        String day = String.valueOf(faker.number().numberBetween(10,28));
        String month = String.valueOf(faker.number().numberBetween(1,9));
        String year = String.valueOf(faker.number().numberBetween(1950,2000));
        month = "0"+month;
        String fechaString = day+month+year;
        return fechaString;
    }

    public static List<Passenger> createPassengers(int numPassengers) {
        List<Passenger> passengers = new ArrayList<>();

        Faker faker = new Faker(new Locale("es"));
        Faker fakerus = new Faker(new Locale("us"));

        String[] genders = {"Masculino", "Femenino"};

        for (int i = 0; i < numPassengers; i++) {
            String firstName = fakerus.name().firstName();
            String lastName = fakerus.name().lastName();
            String birthdate = generarFecha();
            String gender = genders[faker.random().nextInt(genders.length)];
            String documentNumber = faker.number().digits(10);
            String phoneNumber = faker.number().digits(10);
            Passenger passenger = new Passenger(firstName, lastName, birthdate, gender, documentNumber, phoneNumber);
            passengers.add(passenger);
        }
        return passengers;
    }

}
