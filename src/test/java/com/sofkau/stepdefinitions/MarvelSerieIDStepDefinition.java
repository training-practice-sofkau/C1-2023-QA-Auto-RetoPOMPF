package com.sofkau.stepdefinitions;

import com.sofkau.setup.MarvelSerieIdSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.when;

public class MarvelSerieIDStepDefinition extends MarvelSerieIdSetup {


    public static final Logger LOGGER = Logger.getLogger(MarvelSerieIDStepDefinition.class);
    private Response response;


    String url = String.format("%s://%s/%s/%s/%s/%d?apikey=%s&ts=%d&hash=%s",
            protocol, host, version, resourceType, resourceSubtype, resourceId, apiKey, timestamp, hash);

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("que soy un usuario de la API de Marvel")
    public void queSoyUnUsuarioDeLaAPIDeMarvel() {
        generalSetup();
    }

    @When("solicito obtener la serie de Marvel por ID")
    public void solicitoObtenerLaSerieDeMarvelPorID() {
        response = when().get(url);
    }

    @Then("la API responde la informacion correspondiente")
    public void laAPIRespondeLaInformacionCorrespondiente() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String ID = (String) firstResult.get("26024");
            String title = (String) firstResult.get("title");
            System.out.println(title);
            Assertions.assertEquals(" Superior Spider-Man Vol. 2: Otto-matic (2019)", title);
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}
