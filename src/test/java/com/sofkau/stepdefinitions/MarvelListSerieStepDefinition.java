package com.sofkau.stepdefinitions;


import com.sofkau.setup.MarverlListSerieSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.when;


public class MarvelListSerieStepDefinition extends MarverlListSerieSetup {

    public static final Logger LOGGER = Logger.getLogger(MarvelListSerieStepDefinition.class);
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    String url = String.format("%s://%s/%s/%s/%s?apikey=%s&ts=%d&hash=%s",
            protocol, host, version, resourceType, resourceSubtype, apiKey, timestamp, hash);


    @Given("que soy el usuario de la API de marvel")
    public void queSoyElUsuarioDeLaAPIDeMarvel() {
        generalSetup();

    }

    @When("el ususario solicito obtener todas las series de marvel universe")
    public void elUsusarioSolicitoObtenerTodasLasSeriesDeMarvelUniverse() {
        response = when().get(url);
    }

    @Then("la API responde una lista de todas las series de marvel.")
    public void laAPIRespondeUnaListaDeTodasLasSeriesDeMarvel() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String title = (String) firstResult.get("title");
            System.out.println(title);
            Assertions.assertEquals(" Fantastic Four by Dan Slott Vol. 1 (2021)", title);
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


    @Given("que soy un usuario de la API de Marvel Universe")
    public void queSoyUnUsuarioDeLaAPIDeMarvelUniverse() {
        generalSetup();
    }

    @When("el usuario  obtiene todas las series de marvel")
    public void elUsuarioObtieneTodasLasSeriesDeMarvel() {
        response = when().get(url);

    }

    @Then("la API responde error en la solicitud")
    public void laAPIRespondeErrorEnLaSolicitud() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String title = (String) firstResult.get("title");
            Assertions.assertEquals(" Fantastic Four by Dan Slott Vol. 1 (2021)", title);
            Assertions.assertEquals(response.getStatusCode(), 400);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

}