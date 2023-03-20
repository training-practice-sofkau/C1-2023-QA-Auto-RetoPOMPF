package com.sofkau.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

public class DerivateStepDefinition {
    JSONParser parser=new JSONParser();
    JSONObject resbody=new JSONObject();
    public static java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(DerivateStepDefinition.class));
    private String body;
    private Response response;

    @Given("que accedo a la pagina de coingecko para usar el servicio GET derivate exchange")
    public void queAccedoALaPaginaDeCoingeckoParaUsarElServicioGETDerivateExchange() {
        RestAssured.baseURI="https://api.coingecko.com/api";
    }
    @When("envio una peticion para ver la informacion del nft con id {string}")
    public void envioUnaPeticionParaVerLaInformacionDelNftConId(String id) {
        response=RestAssured.given().get("https://api.coingecko.com/api/v3/derivatives/exchanges/"+id);
    }
    @Then("recibo un codigo doscientos de respuesta exitosa")
    public void reciboUnCodigoDoscientosDeRespuestaExitosa() {
        Assertions.assertEquals(response.getStatusCode(), 200);
    }
    @Then("muestra la informacion del intercambio derivado")
    public void muestraLaInformacionDelIntercambioDerivado() {
        try{
            resbody=(JSONObject) response.getBody();
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        Assertions.assertNotNull(resbody);
    }

}
