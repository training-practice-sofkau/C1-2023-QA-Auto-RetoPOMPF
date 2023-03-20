package models;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class Passenger {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String id;
    private String email;
    private String phoneNumber;

    public Passenger(String firstName, String lastName, String birthdate,
                     String id, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.id = id;
        this.email = email;
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


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Passenger generateInfantPassenger() {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, faker.number().numberBetween(2020, 2023));
        calendar.set(Calendar.MONTH, faker.number().numberBetween(0, 11));
        calendar.set(Calendar.DAY_OF_MONTH, faker.number().numberBetween(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String birthdate = date.format(calendar.getTime());
        String id = faker.number().digits(10);
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        return new Passenger(firstName, lastName, birthdate, id, email, phoneNumber);
    }

    public static Passenger generateChildPassenger() {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, faker.number().numberBetween(2006, 2020));
        calendar.set(Calendar.MONTH, faker.number().numberBetween(0, 11));
        calendar.set(Calendar.DAY_OF_MONTH, faker.number().numberBetween(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String birthdate = date.format(calendar.getTime());
        String id = faker.number().digits(10);
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        return new Passenger(firstName, lastName, birthdate, id, email, phoneNumber);
    }

    public static Passenger generateAdultPassenger() {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, faker.number().numberBetween(1903, 2005));
        calendar.set(Calendar.MONTH, faker.number().numberBetween(0, 11));
        calendar.set(Calendar.DAY_OF_MONTH, faker.number().numberBetween(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String birthdate = date.format(calendar.getTime());
        String id = faker.number().digits(10);
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        return new Passenger(firstName, lastName, birthdate, id, email, phoneNumber);
    }
}