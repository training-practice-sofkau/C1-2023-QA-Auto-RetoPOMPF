package com.sofkau.util;

import com.sofkau.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerInstance {

    List<Passenger> passengers = new ArrayList<>();

    public Passenger passenger1 = new Passenger();
    public Passenger passenger2 = new Passenger();
    public Passenger passenger3 = new Passenger();

    public void fillPassengerInfo(){
        passenger1.setFirstName("Andres");
        passenger1.setLastName("Yepes");
        passenger1.setDateOfBirth("01021991");
        passenger1.setIdentification("1037542698");
        passenger1.setEmail("madisih297@necktai.com");
        passenger1.setPhone("6042550489");

        passenger2.setFirstName("Julio");
        passenger2.setLastName("Moreno");
        passenger2.setDateOfBirth("02031993");
        passenger2.setIdentification("1037789654");
        passenger2.setEmail("madisih297@necktai.com");
        passenger2.setPhone("6043435810");

        passenger3.setFirstName("Matias");
        passenger3.setLastName("Yepes");
        passenger3.setDateOfBirth("20032022");
        passenger3.setIdentification("10180089877");
        passenger3.setEmail("madisih297@necktai.com");
        passenger3.setPhone("6043435810");


    }

    public List<Passenger> getPassengerList(){
        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);

        return passengers;
    }
}
