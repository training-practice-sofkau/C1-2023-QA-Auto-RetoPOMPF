package com.sofkau.stepdefinitionservices;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Assert;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Step3 extends WebUI {

    private Response response;
    private final static Logger logger = Logger.getLogger(String.valueOf(Step3.class));

    @Given("^que tengo la URL del servicio COVID-19 de EE\\.UU\\.$")
    public void tengo_la_url_del_servicio() {
        RestAssured.baseURI = "https://api.covidtracking.com/v1/us/daily.json";
    }

    @When("^realizo una solicitud GET al servicio$")
    public void realizo_solicitud_GET() {
        response = RestAssured.given().when().get();
    }

    @Then("^la respuesta debe ser exitosa$")
    public void la_respuesta_debe_ser_exitosa() {
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("La respuesta es exitosa");
    }

    @Then("^la respuesta debe contener datos diarios de COVID-19 de EE\\.UU\\.$")
    public void la_respuesta_debe_contener_datos_diarios() throws Exception {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(responseBody);

        // Validar que el primer elemento del JSON tenga los atributos esperados
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        Assert.assertTrue(jsonObject.containsKey("date"));
        Assert.assertTrue(jsonObject.containsKey("positive"));
        Assert.assertTrue(jsonObject.containsKey("negative"));
        Assert.assertTrue(jsonObject.containsKey("death"));

        logger.info("La respuesta contiene datos diarios de COVID-19 de EE.UU.");
    }
}
