package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class ApiCovidTrackingCurrentStepDefinition {
    private Response response;
    @Given("que el administrador se encuentra en la pagina")
    public void queElAdministradorSeEncuentraEnLaPagina() {
        RestAssured.baseURI = "https://api.covidtracking.com/";
    }
    @When("realiza una solicitud a la API para el estado CA")
    public void realizaUnaSolicitudALaAPIParaElEstadoCA() {
        response = RestAssured.when()
                .get("v1/states/ca/current.json");
    }
    @Then("debera recibir una respuesta que contenga los datos diarios mas actuales de COVID para CA")
    public void deberaRecibirUnaRespuestaQueContengaLosDatosDiariosMasActualesDeCOVIDParaCA() {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(200,response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String state = (String) jsonObject.get("state");
        Assertions.assertEquals("CA", state);

    }

    @When("envia una solicitud a la API incorrecta")
    public void enviaUnaSolicitudALaAPIIncorrecta() {
        response = RestAssured.when()
                .get("v1/states/00/current.json");
    }
    @Then("debera recibir una respuesta de error verdadera")
    public void deberaRecibirUnaRespuestaDeErrorVerdadera() {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(404,response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (jsonObject.containsKey("error")) {
            Object errorValue = jsonObject.get("error");

            if (errorValue instanceof Boolean) {
                Boolean error = (Boolean) errorValue;
                Assertions.assertTrue(error);
            } else {
                Assertions.fail("El valor de la clave \"error\" no es de tipo Boolean");
            }
        } else {
            Assertions.fail("El objeto JSON no contiene la clave \"error\"");
        }
    }
}
