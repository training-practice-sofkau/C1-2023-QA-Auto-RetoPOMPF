package com.sofka.stepdefinitions;

import com.sofka.pages.CommonActionOnPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class ApiCurrentValuesStateDateStepDefinition {
    private Response response;

    @Given("que el administrador ingresa el estado y fecha")
    public void queElAdministradorIngresaElEstadoYFecha() {
        RestAssured.baseURI = "https://api.covidtracking.com/";
    }

    @When("envia una solicitud valida tipo GET a la API")
    public void enviaUnaSolicitudValidaTipoGETALaAPI() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/v1/states/mt/20200401.json");
    }

    @Then("debera recibir una respuesta con un estado ok")
    public void deberaRecibirUnaRespuestaConUnEstadoOk() {
        String responseBody = response.then().log().all().statusCode(200).extract().body().asString();
        Assertions.assertEquals(200, response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException exception){
            exception.printStackTrace();
        }

        if(jsonObject != null){
            String state = (String) jsonObject.get("state");
            Long date = (Long) jsonObject.get("date");
            Long positive = (Long) jsonObject.get("positive");

            Assertions.assertEquals("MT", state);
            Assertions.assertEquals(20200401, date);
            Assertions.assertTrue(positive>0);
        } else {
            Assertions.fail("El objeto JSON está vacío");
        }
    }
}