package com.sofkau.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import org.json.simple.parser.JSONParser;

import static com.sofka.setup.ConstantSetup.COMPLEMENTURL;
import static com.sofka.setup.ConstantSetup.URLget;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class CoinsIdStepDefinition {

    Response response;
    JSONObject responseBody;
    JSONObject responseBody2;
    JSONParser parser = new JSONParser();
    public static Logger LOGGER = Logger.getLogger(CoinsIdStepDefinition.class);

    @Given("que el usuario esta en la API coingecko")
    public void queElUsuarioEstaEnLaAPICoingecko() {
        RestAssured.baseURI = URLget;
        RestAssured.basePath = COMPLEMENTURL;
        given().contentType(ContentType.JSON);
    }
    @When("manda una peticion GET con {string} validos")
    public void mandaUnaPeticionGETConValidos(String id) {
        response =   when().get(String.format(URLget + COMPLEMENTURL + id));

    }

    @Then("debe observar el {string} de la criptomoneda y un {int}")
    public void debe_observar_el_de_la_criptomoneda_y_un(String name, Integer status) {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( response.getStatusCode(), status);
            Assertions.assertEquals( name, responseBody.get("name"));
            LOGGER.info("cryptocurrency: " + responseBody.get("name"));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @Given("que el usuario esta en la API coningecko")
    public void queElUsuarioEstaEnLaAPIConingecko() {
        RestAssured.baseURI = URLget;
        RestAssured.basePath = COMPLEMENTURL;
        given().contentType(ContentType.JSON);

    }
    @When("manda una peticion GET con id invalidos")
    public void mandaUnaPeticionGETConIdInvalidos() {
        response =   when().get(String.format(URLget + COMPLEMENTURL + "fsfse"));

    }
    @Then("debe observar un mensaje de error y un status {int} not found")
    public void debeObservarUnMensajeDeErrorYUnStatusNotFound(Integer int1) {
        try {
            responseBody2 = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals( response.getStatusCode(), int1);
            Assertions.assertEquals( "coin not found", responseBody2.get("error"));
            LOGGER.info("Error: "+responseBody2.get("error"));


        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

}
