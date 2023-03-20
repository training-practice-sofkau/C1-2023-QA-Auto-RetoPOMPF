package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class positiveTestsViralStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(Covid19StepDefinition.class);

    private String endpoint;
    private Response response;

    @Given("El endpoint del servicio COVID-19 API es {string}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("Realizo una solicitud GET para el estado {string}")
    public void getRequestForState(String state) {
        response = RestAssured
                .given()
                .baseUri(endpoint)
                .basePath("/v1/states/" + state + "/current.json")
                .get();
    }

    @Then("Deberia recibir una respuesta con el numero de positiveTestsViral")
    public void deberiaRecibirUnaRespuestaConElNumeroDePositiveTestsViral() {
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        int positiveTestsViral = jsonPath.getInt("positiveTestsViral");
        Assert.assertTrue("El número de positiveTestsViral debe ser mayor o igual a cero", positiveTestsViral >= 0);
        System.out.println("Estado: North Dakota - positiveTestsViral: " + positiveTestsViral);
    }
}

