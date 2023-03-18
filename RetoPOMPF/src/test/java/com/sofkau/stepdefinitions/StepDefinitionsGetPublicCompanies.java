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

public class StepDefinitionsGetPublicCompanies extends Log4jSetUp {
    public static Logger LOGGER = Logger.getLogger(StepDefinitionGetExchanges.class);

    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    @Given("el usuario ingresa a la pagina web de coingecko")
    public void elUsuarioIngresaALaPaginaWebDeCoingecko() {
        generalSetUp();
        LOGGER.info("Inicio de la automatización");
    }

    // Scenario: id valido
    @When("realiza una peticion GET con un id valido")
    public void realizaUnaPeticionGETConUnIdValido() {
        LOGGER.info("Scenario: id valido");
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .get(VALID_PUBLIC_COMPANIES_ID);
    }
    @Then("retorna un codigo status OK")
    public void retornaUnCodigoStatusOK() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 200);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("se lista la informacion de las empresas publicas")
    public void seListaLaInformacionDeLasEmpresasPublicas() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertNotNull(responseBody.get("total_holdings"));
            Assertions.assertNotNull(responseBody.get("total_value_usd"));
            Assertions.assertNotNull(responseBody.get("market_cap_dominance"));
            Assertions.assertNotNull(responseBody.get("companies"));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    // Scenario: id invalido

    @When("realiza una peticion Get ingresando un id invalido")
    public void realizaUnaPeticionGetIngresandoUnIdInvalido() {
        LOGGER.info("Scenario: ");
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .get(INVALID_PUBLIC_COMPANIES_ID);
    }
    @Then("retorna un codigo de Status Not Found")
    public void retornaUnCodigoDeStatusNotFound() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 404);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
