package com.sofkau.stepdefinitions;

import com.sofkau.setup.MarvelEventosSetup;
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

public class StepEventos extends MarvelEventosSetup {
    public static final Logger LOGGER = Logger.getLogger(StepHistorias .class);
    private Response response;
    String url = baseURL + endpoint + "?apikey=" + apiKey + "&ts=" + timestamp + "&hash=" + hash;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    @Given("que soy un usuario de los  eventos de la API de marvel")
    public void queSoyUnUsuarioDeLosEventosDeLaAPIDeMarvel() {
        generalSetup();
    }
    @When("solicito obtener eventos filtrados por historia")
    public void solicitoObtenerEventosFiltradosPorHistoria() {
        response = when().get(url);
    }
    @Then("la API retorna el evento por id de comic")
    public void laAPIRetornaElEventoPorIdDeComic() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            LOGGER.info(data);
            //JSONArray results = (JSONArray) data.get("results");
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }

    }
}
