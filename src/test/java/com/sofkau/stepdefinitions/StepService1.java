package com.sofkau.stepdefinitions;

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

public class StepService1 extends WebUI {

    private static final Logger LOGGER = LogManager.getLogger(StepService1.class);
    private Response response;

    @Given("que el usuario hace una solicitud GET a la API de datos COVID-{int}")
    public void queElUsuarioHaceUnaSolicitudGETALaAPIDeDatosCOVID(Integer int1) {
        RestAssured.baseURI = "https://api.covidtracking.com/v1";
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
        int bandera = 0;
        for (Object obj : jsonArray) {
            JSONObject json = (JSONObject) obj;
            Long positiveCases = (Long) json.get("positive");
            //LOGGER.info(state + " tiene " + positiveCases + " casos positivos de COVID-19.");
            if (bandera == 0) {
                Assertions.assertEquals("56886", positiveCases+"");
                LOGGER.info("Valor esperado: 56886, Valor obtenido: "+positiveCases);
                bandera = 1;
            }
        }
    }
}




