package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class StepDefinitionS2 {
    private static final Logger logger = Logger.getLogger(StepDefinitionS2.class);
    private Response response;

    @Given("^que hago una peticion GET a \"([^\"]*)\"$")
    public void que_hago_una_peticion_GET_a(String url) throws Throwable {
        response = RestAssured.get(url);
    }

    @When("^la peticion es exitosa$")
    public void la_peticion_es_exitosa() {

    }
    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(Integer int1) {
        int statusCode = response.getStatusCode();
        logger.info("El codigo de respuesta es: " + statusCode);
        Assert.assertEquals(200, statusCode);
    }
    @Then("el cuerpo de la respuesta contiene la informacion de COVID19 del estado de California el 1demayode2020")
    public void elCuerpoDeLaRespuestaContieneLaInformacionDeCOVID19DelEstadoDeCaliforniaEl1demayode2020() throws ParseException {

        String responseBody = response.getBody().asString();
        logger.info("El cuerpo de la respuesta es: " + responseBody);

        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
            String[] expectedFields = {"state", "date"};
            String[] expectedValues = {"CA", "20200501"};

            // Verificar que los campos y valores esperados estén presentes en la respuesta
            for (int i = 0; i < expectedFields.length; i++) {
                String field = expectedFields[i];
                String expectedValue = expectedValues[i];
                Assert.assertTrue("El campo " + field + " no está presente en la respuesta", jsonObject.containsKey(field));
                String actualValue = String.valueOf(jsonObject.get(field));
                Assert.assertEquals("El valor del campo " + field + " no es el esperado", expectedValue, actualValue);
                logger.info(String.format("| %-10s | %-10s | %-10s |", field, expectedValue, actualValue));
            }

            Assert.assertNotNull(responseBody);
        } catch (ParseException e) {
            Assert.fail("No se pudo procesar el cuerpo de la respuesta");
        } catch (ClassCastException e) {
            Assert.fail("No se pudo convertir el objeto JSON");
        }

}}