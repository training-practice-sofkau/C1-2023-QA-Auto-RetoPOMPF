package com.sofka.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class ApiStateCurrentStepDefinition {
    private Response response;

    @Given("que el administrador invoca a la API")
    public void queElAdministradorInvocaALaAPI() {
        RestAssured.baseURI = "https://api.covidtracking.com/";
    }

    @When("envia una solicitud valida tipo GET en la API")
    public void enviaUnaSolicitudValidaTipoGETEnLaAPI() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/v1/states/current.json");
    }

    @Then("debera recibir una respuesta con estado ok")
    public void deberaRecibirUnaRespuestaConEstadoOk() {
        String responseBody = response.then().log().all().statusCode(200).extract().body().asString();
        Assertions.assertEquals(200, response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(responseBody);

        } catch (ParseException exception){
            exception.printStackTrace();
        }

        if(jsonArray != null){
            Assertions.assertEquals(56, jsonArray.size());
        } else {
            Assertions.fail("El objeto JSON está vacío");
        }
    }
}