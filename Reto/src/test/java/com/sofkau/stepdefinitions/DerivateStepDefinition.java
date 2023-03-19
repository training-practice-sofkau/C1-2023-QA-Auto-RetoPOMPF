package com.sofkau.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DerivateStepDefinition {
    private String body;
    private Response response;

    @Given("que accedo a la pagina de coingecko para usar el servicio GET derivate exchange")
    public void queAccedoALaPaginaDeCoingeckoParaUsarElServicioGETDerivateExchange() {
        RestAssured.baseURI="https://api.coingecko.com/api";
    }
    @When("envio una peticion para ver la informacion del nft con id {string}")
    public void envioUnaPeticionParaVerLaInformacionDelNftConId(String id) {
        response=RestAssured.given().get("https://api.coingecko.com/api/v3/derivatives/exchanges/"+id);
        System.out.println(id);
    }
    @Then("recibo un codigo doscientos de respuesta exitosa")
    public void reciboUnCodigoDoscientosDeRespuestaExitosa() {
        Assertions.assertEquals(response.getStatusCode(), 200);
    }
    @Then("muestra la informacion del intercambio derivado")
    public void muestraLaInformacionDelIntercambioDerivado() {
        body="a";
        System.out.println(body);
        body= response.asString();
        System.out.println(body);
    }

}
