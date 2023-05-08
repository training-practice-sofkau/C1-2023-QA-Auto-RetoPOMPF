package com.sofkau.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import static com.sofka.setup.ConstantSetup.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CoinsHistoryStepDefinition {

    Response response;
    JSONObject responseBody;
    JSONObject responseBody2;
    JSONParser parser = new JSONParser();
    public static Logger LOGGER = Logger.getLogger(CoinsIdStepDefinition.class);
    @Given("que el usuario usuario esta en la API coingecko")
    public void queElUsuarioUsuarioEstaEnLaAPICoingecko() {
        RestAssured.baseURI = URLget;
        RestAssured.basePath = COMPLEMENTURL;
        given().contentType(ContentType.JSON);

    }
    @When("manda una peticion GET con {string} y {string} validos")
    public void mandaUnaPeticionGETConYValidos(String id, String date) {
        response =   when().get(String.format(URLget + COMPLEMENTURL + id + COMPLEMENTURLHISTORY + date));
    }
    @Then("debe observar {string} de la criptomoneda y {int}")
    public void debeObservarDeLaCriptomonedaY(String symbol, Integer status) {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( response.getStatusCode(), status);
            Assertions.assertEquals( symbol, responseBody.get("symbol"));
            LOGGER.info("cryptocurrency: " + responseBody.get("symbol"));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @Given("que el usuario esta en la API Coingecko")
    public void que_el_usuario_esta_en_la_api_coingecko() {
        RestAssured.baseURI = URLget;
        RestAssured.basePath = COMPLEMENTURL;
        given().contentType(ContentType.JSON);
    }
    @When("manda una peticion GET con id valido y date incompleto")
    public void manda_una_peticion_get_con_id_valido_y_date_incompleto() {
        response =   when().get(String.format(URLget + COMPLEMENTURL + "aktio" + COMPLEMENTURLHISTORY + "04-01-2"));
    }
    @Then("debe observar un mensaje de error y un status {int} bad request")
    public void debe_observar_un_mensaje_de_error_y_un_status_bad_request(Integer status) {
        try {
            responseBody2 = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( response.getStatusCode(), status);
            Assertions.assertEquals( "invalid date", responseBody2.get("error"));
            LOGGER.info("cryptocurrency: " + responseBody2.get("error"));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

}
