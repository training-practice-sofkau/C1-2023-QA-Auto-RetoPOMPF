package com.sofkau.util;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Person {
    private String nombre;
    private String apellido;
    private String email;

    private String celular;
    private String fechaNacimienti;
    private String idcc;
    private String direccion;
    Faker faker = new Faker();

    public Person() {
        this.nombre = faker.name().firstName();
        this.apellido = faker.name().lastName();
        this.email = "esogaviria@gmail.com";
        this.celular = "3117058334";
        this.fechaNacimienti = dateAleatory();
        this.idcc = faker.number().digits(10);
    }

    public String   dateAleatory(){
        Faker faker = new Faker();
        LocalDate date;
        do {
            date = faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        } while (date.getYear() < 1950 || date.getYear() > 2023);
        String formattedDate = date.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(formattedDate);
        return  formattedDate;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public String getFechaNacimienti() {
        return fechaNacimienti;
    }

    public String getIdcc() {
        return idcc;
    }

    public String getDireccion() {
        return direccion;
    }
}
