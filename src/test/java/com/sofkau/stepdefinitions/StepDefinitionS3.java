package com.sofkau.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StepDefinitionS3 {

    private String url;
    private Response response;
    private Logger logger = Logger.getLogger(StepDefinitionS3.class);
    private JSONParser parser = new JSONParser();

    @Given("que el usuario tiene acceso a la API")
    public void que_el_usuario_tiene_acceso_a_la_API() {
        url = "https://api.covidtracking.com/v1/states/ca/current.json";
    }

    @When("se envia una solicitud GET a {string}")
    public void se_envia_una_solicitud_GET_a(String endpoint) {
        response = given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        logger.info("La respuesta es: " + response.asString());
    }

    @Then("la respuesta deberia tener un codigo de estado {int}")
    public void la_respuesta_deberia_tener_un_codigo_de_estado(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
        logger.info("El codigo de estado es: " + actualStatusCode);
    }

    @Then("la respuesta deberia contener los datos del estado de CA")
    public void la_respuesta_deberia_contener_los_datos_del_estado_de_CA() throws Exception {
        String responseBody = response.getBody().asString();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);

        // Assert state value
        String state = (String) jsonObject.get("state");
        Assert.assertEquals("CA", state);

        // Assert numeric values
        Map<String, Integer> expectedValues = new HashMap<>();
        expectedValues.put("positive", 3501394);
        expectedValues.put("totalTestResults", 49646014);
        expectedValues.put("hospitalizedCurrently", 4291);
        expectedValues.put("inIcuCurrently", 1159);
        expectedValues.put("death", 54124);

        for (String key : expectedValues.keySet()) {
            Object valueObj = jsonObject.get(key);
            if (valueObj == null) {
                fail(String.format("Expected %s value not found in response", key));
            }
            String valueStr = valueObj.toString();
            if (!StringUtils.isNumeric(valueStr)) {
                fail(String.format("%s value is not numeric: %s", key, valueStr));
            }
            int value = Integer.parseInt(valueStr);
            int expectedValue = expectedValues.get(key);
            Assert.assertEquals(String.format("%s value is not as expected", key), expectedValue, value);

            // Log expected and obtained values
            logger.info(String.format("| %s\t| %d\t\t| %d\t\t|", key, expectedValue, value));
        }

        logger.info("Todos los valores son los esperados");

}}

