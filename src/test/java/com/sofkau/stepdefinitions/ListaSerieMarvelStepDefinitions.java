package com.sofkau.stepdefinitions;

import com.sofkau.setup.ListaSerieMarvelStep;
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
//https://gateway.marvel.com:443/v1/public/series?apikey=808226567a307a28cb7baf585c3941d3&ts=1&hash=867b39a58fba3884fb2e3a30590ab044
public class ListaSerieMarvelStepDefinitions extends ListaSerieMarvelStep {

    public static final Logger LOGGER = Logger.getLogger(ListaSerieMarvelStepDefinitions.class);
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    String url = String.format("%s://%s/%s/%s/%s?apikey=%s&ts=%d&hash=%s",
            protocol, host, version, resourceType, resourceSubtype, apiKey, timestamp, hash);

    @Given("soy usuario de la API de marvel")
    public void soy_usuario_de_la_api_de_marvel() {
        generalSetup();

    }
    @When("el ususario solicita tener las series de marvel")
    public void el_ususario_solicita_tener_las_series_de_marvel() {
        response = when().get(url);
    }
    @Then("deberia mostrar una lista con todas las series")
    public void deberia_mostrar_una_lista_con_todas_las_series() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(9);
            String title = (String) firstResult.get("title");
            System.out.println(title);
           // LOGGER.info(data);
            Assertions.assertEquals("1939 Daily Bugle (2009 - Present)",title);
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
