package com.sofkau;

import com.sofkau.models.Passenger;

import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        List<Passenger> passengers = Passenger.createPassengers(3);
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getFirstName());
            System.out.println(passenger.getLastName());
            System.out.println(passenger.getBirthdate());
            System.out.println(passenger.getGender());
            System.out.println(passenger.getDocumentNumber());
            System.out.println(passenger.getPhoneNumber());
        }
    }
}
