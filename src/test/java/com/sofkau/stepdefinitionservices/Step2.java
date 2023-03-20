package com.sofkau.stepdefinitionservices;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Step2 extends WebUI {

    private static final String BASE_URI = "https://api.covidtracking.com/v1";

    private static final Logger LOGGER = LogManager.getLogger(Step2.class);

    private Response response;

    @Given("que el usuario hace una solicitud GET a la API de datos COVID-{int}")
    public void queElUsuarioHaceUnaSolicitudGETALaAPIDeDatosCOVID(Integer int1) {
        RestAssured.baseURI = BASE_URI;
    }

    @When("la solicitud se realiza para obtener los datos de COVID-{int} por estado")
    public void laSolicitudSeRealizaParaObtenerLosDatosDeCOVIDPorEstado(Integer int1) {
        response = RestAssured.given().get("states/current.json");

    }
    @Then("se debe devolver una respuesta exitosa con los datos de COVID-{int} por estado")
    public void seDebeDevolverUnaRespuestaExitosaConLosDatosDeCOVIDPorEstado(Integer int1) throws ParseException {
        int expectedStatusCode = 200;
        int actualStatusCode = response.getStatusCode();
        LOGGER.info("Valor esperado: " + expectedStatusCode + ", valor obtenido: " + actualStatusCode);
        Assertions.assertEquals(expectedStatusCode, actualStatusCode);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(response.getBody().asString());
        for (Object obj : jsonArray) {
            JSONObject json = (JSONObject) obj;
            String state = (String) json.get("state");
            Long positiveCases = (Long) json.get("positive");
            LOGGER.info(state + " tiene " + positiveCases + " casos positivos de COVID-19.");
        }
    }
}


