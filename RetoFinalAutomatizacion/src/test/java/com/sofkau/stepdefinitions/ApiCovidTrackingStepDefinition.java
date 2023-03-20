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

public class ApiCovidTrackingStepDefinition {
    private Response response;

    @Given("que el administrador esta en la pagina")
    public void queElAdministradorEstaEnLaPagina() {

        RestAssured.baseURI = "https://api.covidtracking.com/";
    }
    @When("hace una solicitud a la API para el estado CA")
    public void haceUnaSolicitudALaAPIParaElEstadoCA() {
        response = RestAssured.when()
                .get("v1/states/ca/info.json");
    }
    @Then("debera recibir una respuesta que contenga los datos de COVID para CA")
    public void deberaRecibirUnaRespuestaQueContengaLosDatosDeCOVIDParaCA() {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(200,response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String state = (String) jsonObject.get("name");
        String siteWeb = (String) jsonObject.get("covid19Site");
        Assertions.assertEquals("California", state);
        Assertions.assertEquals("https://update.covid19.ca.gov",siteWeb);
    }

    @When("hace una solicitud a la API incorrecta")
    public void haceUnaSolicitudALaAPIIncorrecta() {
        response = RestAssured.when()
                .get("v1/states/00/info.json");
    }
    @Then("debera recibir una respuesta de error")
    public void deberaRecibirUnaRespuestaDeError() {
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
