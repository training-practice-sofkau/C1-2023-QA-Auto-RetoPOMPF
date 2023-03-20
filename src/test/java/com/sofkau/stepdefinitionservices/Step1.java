package com.sofkau.stepdefinitionservices;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Step1 {


    private Response response;

    @Given("que estoy en el sitio web de COVID Tracking Project")
    public void queEstoyEnElSitioWebDeCOVIDTrackingProject() {
        RestAssured.baseURI = "https://api.covidtracking.com";
        RestAssured.basePath = "/v1";
    }

    @When("una peticion GET al servicio US Current Hospitalizations")
    public void unaPeticionGETAlServicioUSCurrentHospitalizations() {
        response = RestAssured.given().when().get();
    }

    @Then("la respuesta deberia tener un código de estado {int}")
    public void thenResponseCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("el numero de hospitalizaciones actuales debería ser un numero positivo")
    public void thenCurrentHospitalizationsShouldBePositive() {
        response.then().body("hospitalizedCurrently", greaterThan(0));
        System.out.println("El número de hospitalizaciones actuales es: " + response.path("hospitalizedCurrently"));
    }

}


