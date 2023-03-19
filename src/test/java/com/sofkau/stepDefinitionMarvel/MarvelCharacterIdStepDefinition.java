package com.sofkau.stepDefinitionMarvel;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.ConstantSetup.APIMARVEL_URL;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class MarvelCharacterIdStepDefinition extends WebUI {

    public static final Logger LOGGER = LoggerFactory.getLogger(MarvelCharacterIdStepDefinition.class);


    String id = "1011334";
    String apiKey = "519be85584de1be15e49e05d435430d6";
    String ts = "1";
    String hash = "5dcd64e699b6a72f1e891978296aba78";

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    protected Response response;

    @Given("que tengo acceso a la API de Marvel con credencial valida")
    public void queTengoAccesoALaAPIDeMarvelConCredencialValida() {
        generalSetUpMarvel();

    }
    @When("realizo una solicitud de la informacion")
    public void realizoUnaSolicitudDeLaInformacion() {
        RestAssured.baseURI = APIMARVEL_URL;

        response = given()
                .log()
                .all()
                .when()
                .get("/v1/public/characters/" + id + "?apikey=" + apiKey + "&ts=" + ts + "&hash=" + hash);
    }

    @Then("deberia recibir una respuesta con informacion detallada del personaje")
    public void deberiaRecibirUnaRespuestaConInformacionDetalladaDelPersonaje() {
        response.then()
                .log()
                .all();


        try {
            LOGGER.info("Test Pasó");
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( 200, response.getStatusCode());
            assertEquals("Ok", responseBody.get("status"));
            JSONObject dataObject = (JSONObject)  responseBody.get("data");
            assertEquals(1L, dataObject.get("total"));
            JSONArray resultsArray = (JSONArray) dataObject.get("results");
            JSONObject characterObject = (JSONObject) resultsArray.get(0);
            assertEquals(1011334L, characterObject.get("id"));
            assertEquals("3-D Man", characterObject.get("name"));
            assertEquals("", characterObject.get("description"));
            JSONObject thumbnailObject = (JSONObject) characterObject.get("thumbnail");
            assertEquals("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", thumbnailObject.get("path"));
            assertEquals("jpg", thumbnailObject.get("extension"));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

}
