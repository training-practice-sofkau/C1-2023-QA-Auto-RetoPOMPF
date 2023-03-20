package com.sofkau.stepdefinitions;

import com.sofkau.setup.BuscarPorIdHistoriaMarvelSetup;
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

public class BuscarPorIdHistoriaMarvelStepDefinitions extends BuscarPorIdHistoriaMarvelSetup {

    public static final Logger LOGGER = Logger.getLogger(BuscarPorIdHistoriaMarvelStepDefinitions.class);
    private Response response;

    private RequestSpecification resquest;

    String url = String.format("%s://%s/%s/%s/%s/%d?apikey=%s&ts=%d&hash=%s",
            protocol, host, version, resourceType, resourceSubtype, resourceId, apiKey, timestamp, hash);

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("soy usuario la API de marvel")
    public void soy_usuario_la_api_de_marvel() {
        generalSetup();
    }
    @When("el ususario envio una peticion para la lista de historias")
    public void el_ususario_envio_una_peticion_para_la_lista_de_historias() {
        response = when().get(url);
    }
    @Then("deberia mostrar una lista de historias filtrada por id")
    public void deberia_mostrar_una_lista_de_historias_filtrada_por_id() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String ID = (String) firstResult.get("5");
            String title = (String) firstResult.get("title");
            System.out.println(title);
            Assertions.assertEquals("Black Widow Vol. I (1999)", title);
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}
