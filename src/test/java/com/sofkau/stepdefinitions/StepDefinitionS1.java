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

import static com.sofkau.setup.ConstantSetup.COVID_TRACKING;
import static com.sofkau.setup.ConstantSetup.DATOS_DIARIOS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitionS1 {

    private static String baseURL = "https://covidtracking.com";
    private static String endpoint = "/data/api/v1/us/daily.json";
    private Response response;
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(StepDefinitionS1.class));

    @Given("que el administrador esta en la pagina")
    public void queElAdministradorEstaEnLaPagina() {
        LOGGER.info("Inicio de la automatizacion Place Holder");

    }

    @Given("desea obtener los datos diarios de COVIDen Estados Unidos")
    public void deseaObtenerLosDatosDiariosDeCOVIDenEstadosUnidos() {

    }

    @When("hace una peticion GET al servicio")
    public void haceUnaPeticionGETAlServicio() {
        response = RestAssured.get(baseURL + endpoint);


    }

    @Then("el sistema devuelve un JSON con los datos diarios de COVIDen Estados Unidos")
    public void elSistemaDevuelveUnJSONConLosDatosDiariosDeCOVIDenEstadosUnidos() {
        String jsonStr = response.getBody().asString();
        if (isJSONValid(jsonStr)) {
            JSONParser parser = new JSONParser();
            try {
                JSONObject jsonObj = (JSONObject) parser.parse(jsonStr);
                Assert.assertNotNull(jsonObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            Assert.fail("La respuesta no es un JSON válido");
        }
    }

    public boolean isJSONValid(String jsonStr) {
        try {
            new JSONParser().parse(jsonStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    }






