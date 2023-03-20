package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class Covid19StepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(Covid19StepDefinition.class);
    private Response response;

    @Given("el cliente esta configurado para conectarse a la API de CovidTracking")
    public void elClienteEstaConfiguradoParaConectarseALaAPIDeCovidTracking() {
        RestAssured.baseURI = "https://api.covidtracking.com";
    }

    @When("el cliente realiza una solicitud GET para North Dakota")
    public void getRequestForNorthDakota() {
        response = given()
                .get("/v1/states/nd/current.json");
        logger.info("Realizando la solicitud GET para North Dakota");
    }

    @Then("se debe recibir una respuesta con codigo de estado {int}")
    public void seDebeRecibirUnaRespuestaConCodigoDeEstado(Integer int1) {
        Assert.assertEquals("Código de estado incorrecto", 200, response.getStatusCode());
    }

    @Then("la respuesta debe contener el campo negativeTestsAntibody")
    public void verifyNegativeTestsAntibodyField() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(response.getBody().asString());
        Assert.assertTrue("El campo negativeTestsAntibody no está presente en la respuesta",
                jsonResponse.containsKey("negativeTestsAntibody"));
        logger.info("El campo negativeTestsAntibody está presente en la respuesta: {}", jsonResponse.get("negativeTestsAntibody"));
    }
}