package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.setup.ConstantSetup.*;

public class HistoriasStepDefinition {

    private  String id;
    private Response response;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    public static Logger LOGGER= Logger.getLogger(HistoriasStepDefinition.class);

    //Scenario 1
    @Given("tengo la id {string} de una historia")
    public void tengoLaIdDeUnaHistoria(String idSelected) {
        id = idSelected;
    }

    @When("envio una peticion con la id de la historia")
    public void envioUnaPeticionConLaIdDeLaHistoria() {
        RestAssured.baseURI = URI_MARVEL;
        response = RestAssured.get(String.format(PATH_HISTORIAS_MARVEL, id, TIME_STAMP, APIKEY, HASH));
    }
    @Then("debo obtener una respuesta con la historia con es id")
    public void deboObtenerUnaRespuestaConLaHistoriaConEsId() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 200);
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject result1 = (JSONObject) results.get(0);
            Assertions.assertEquals(Long.parseLong(id), result1.get("id"));
            LOGGER.info("Prueba exitosa Esperado:" + id +" Obtenido:"+ result1.get("id"));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 2
    @Given("tengo la id {string} de una historia invalida")
    public void tengoLaIdDeUnaHistoriaInvalida(String idFail) {
        id = idFail;
    }
    @When("envio una peticion con la id invalida de la historia")
    public void envioUnaPeticionConLaIdInvalidaDeLaHistoria() {
        RestAssured.baseURI = URI_MARVEL;
        response = RestAssured.get(String.format(PATH_HISTORIAS_MARVEL, id, TIME_STAMP, APIKEY, HASH));
    }
    @Then("debo obtener un mensaje de error de historia no encontrada")
    public void deboObtenerUnMensajeDeErrorDeHistoriaNoEncontrada() throws ParseException {
        response.then().statusCode(404);
        responseBody = (JSONObject) parser.parse(response.getBody().asString());
        Assertions.assertEquals("We couldn't find that comic_story",responseBody.get("status"));
        LOGGER.info("Prueba exitosa:" + response.asString());
    }
}
