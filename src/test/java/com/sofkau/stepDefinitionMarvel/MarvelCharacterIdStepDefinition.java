package com.sofkau.stepDefinitionMarvel;

import com.sofkau.setup.WebUIMarvel;
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

import static com.sofkau.setup.ConstantSetup.APIMARVEL_URL;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class MarvelCharacterIdStepDefinition extends WebUIMarvel {

    public static final Logger LOGGER = Logger.getLogger(MarvelCharacterIdStepDefinition.class);


    String apiKey = "519be85584de1be15e49e05d435430d6";
    String ts = "1";
    String hash = "5dcd64e699b6a72f1e891978296aba78";

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    protected Response response;

    @Given("que tengo acceso a la API de Marvel con credencial valida")
    public void queTengoAccesoALaAPIDeMarvelConCredencialValida() {
        LOGGER.info("Iniciando la automatizacion...");

    }
    @When("realizo una solicitud de la informacion con {string} del personaje")
    public void realizoUnaSolicitudDeLaInformacionConDelPersonaje(String id) {

        RestAssured.baseURI = APIMARVEL_URL;

        response = given()
                .when()
                .get("/v1/public/characters/" + id + "?apikey=" + apiKey + "&ts=" + ts + "&hash=" + hash);
    }

    @Then("deberia recibir una respuesta con informacion detallada del personaje del {string} solicitado")
    public void deberiaRecibirUnaRespuestaConInformacionDetalladaDelPersonajeDelSolicitado(String id) throws ParseException {
        response.then();

        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( 200, response.getStatusCode());
            assertEquals("Ok", responseBody.get("status"));
            JSONObject dataObject = (JSONObject)  responseBody.get("data");
            assertEquals(1L, dataObject.get("total"));
            JSONArray resultsArray = (JSONArray) dataObject.get("results");
            JSONObject characterObject = (JSONObject) resultsArray.get(0);
            assertEquals(id, characterObject.get("id").toString());

            LOGGER.info("La prueba paso exitosamente.");

        } catch (AssertionError e) {
            LOGGER.error("La prueba fallo. Error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Ocurrio un error durante la ejecución de la prueba. Error: " + e.getMessage());
            throw e;
        }
    }

}
