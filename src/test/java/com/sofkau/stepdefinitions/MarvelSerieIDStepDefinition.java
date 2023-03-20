package com.sofkau.stepdefinitions;

import com.sofkau.setup.MarvelSerieIdSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class MarvelSerieIDStepDefinition extends MarvelSerieIdSetup {


    String apiKey = "d8b3a1f603bf809767844474bdeb690d";
    String ts = "1";
    String hash = "a9c04f1195b3321b57632e6421449c29";

    public static final Logger LOGGER = Logger.getLogger(MarvelSerieIDStepDefinition.class);
    private Response response;


    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("que soy un usuario de la API de Marvel")
    public void queSoyUnUsuarioDeLaAPIDeMarvel() {
        generalSetup();
    }

    @When("solicito obtener la serie de Marvel por {string}")
    public void solicitoObtenerLaSerieDeMarvelPor(String id) {

        RestAssured.baseURI = APIMARVEL_URL;

        response = given()
                .when()
                .get("/v1/public/series/" + id + "?apikey=" + apiKey + "&ts=" + ts + "&hash=" + hash);
    }

    @Then("la API responde la informacion correspondiente {string}")
    public void laAPIRespondeLaInformacionCorrespondiente(String id) {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String ID = (String) firstResult.get("26024");
            String title = (String) firstResult.get("title");
            System.out.println(title);
            Assertions.assertEquals(id, firstResult.get("id").toString());

            //Assertions.assertEquals(" Superior Spider-Man Vol. 2: Otto-matic (2019)", title);
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}
