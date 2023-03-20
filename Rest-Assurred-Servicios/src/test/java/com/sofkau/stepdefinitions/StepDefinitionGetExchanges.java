package com.sofkau.stepdefinitions;

import com.sofkau.setup.Log4jSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.setup.ConstantsSetup.*;

public class StepDefinitionGetExchanges extends Log4jSetUp {
    public static Logger LOGGER = Logger.getLogger(StepDefinitionGetExchanges.class);
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    // Servicio de intercambio existente

    @Given("el usuario accede al servicio Get exchanges de coingeko")
    public void elUsuarioAccedeAlServicioGetExchangesDeCoingeko() {
        generalSetUp();
        LOGGER.info("Inicio de la automatización");
    }
    @When("realiza una peticion al servicio, ingresando un id de mercado intercambio valido")
    public void realizaUnaPeticionAlServicioIngresandoUnIdDeMercadoIntercambioValido() {
        LOGGER.info("Scenario: Servicio de intercambios existente");
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .get(VALID_EXCHANGES_ID);
    }
    @Then("retorna un codigo de status OK")
    public void retornaUnCodigoDeStatusOK() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("lista la informacion del meracado de criptomonedas elegido")
    public void listaLaInformacionDelMeracadoDeCriptomonedasElegido() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(EXCHANGE_NAME, responseBody.get("name"));
            Assertions.assertNotNull(responseBody.get("trust_score"));
            Assertions.assertNotNull(responseBody.get("country"));
            Assertions.assertNotNull(responseBody.get("year_established"));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    // Scenario: Servicio de intercambio inexistente

    @Given("el usuario ingresa al servicio Get exchanges de coingeko")
    public void elUsuarioIngresaAlServicioGetExchangesDeCoingeko() {
        generalSetUp();
        LOGGER.info("Scenario: Servicio de intercambio inexistente");
    }
    @When("realiza una peticion al servicio ingresando un id invalido")
    public void realizaUnaPeticionAlServicioIngresandoUnIdInvalido() {
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .get(INVALID_EXCHANGE_ID);
    }
    @Then("Retorna un codigo de estatus Not Found")
    public void retornaUnCodigoDeEstatusNotFound() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 404);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
