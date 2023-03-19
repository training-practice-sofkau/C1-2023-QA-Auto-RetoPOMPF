package com.sofkau.stepdefinitions;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

public class NftStepDefinition {

    public String idCorrecto="meebits";
    public String idIncorrecto="meebit";
    private String body;
    private Response response;
    @Given("que accedo a la pagina de coingecko para usar el servicio GET nfts")
    public void queAccedoALaPaginaDeCoingeckoParaUsarElServicioGETNfts() {
        RestAssured.baseURI="https://api.coingecko.com/api";
    }
    @When("envio una peticion para ver la informacion del nft con id meebits")
    public void envioUnaPeticionParaVerLaInformacionDelNftConIdMeebits() {
        response=RestAssured.given().get("v3/nfts/"+idCorrecto);

    }
    @Then("recibo un codigo ok de respuesta exitoso")
    public void reciboUnCodigoOkDeRespuestaExitoso() {
        Assertions.assertEquals(response.getStatusCode(), 200);
    }
    @Then("muestra la informacion del nft")
    public void muestraLaInformacionDelNft() {

        body= response.getBody().asString();
        System.out.println(body);
        //JSONParser parser=new JSONParser();
        //JsonObject expected=(JsonObject) parser.parse()

    }
    //______________________________________SCENARIO2________________________________________
    @Given("que accedo a la pagina de coingecko para usar el servicio de GET nfts")
    public void queAccedoALaPaginaDeCoingeckoParaUsarElServicioDeGETNfts() {
        RestAssured.baseURI="https://api.coingecko.com/api";
    }
    @When("envio una peticion para ver la informacion del nft con una id incorrecta")
    public void envioUnaPeticionParaVerLaInformacionDelNftConUnaIdIncorrecta() {
        response=RestAssured.given().get("v3/nfts/"+idIncorrecto);
    }
    @Then("recibo un codigo de respuesta no encontrado")
    public void reciboUnCodigoDeRespuestaNoEncontrado() {
        Assertions.assertEquals(response.getStatusCode(), 404);
    }
    @Then("muestra un mensaje que informa el nft no se encontro")
    public void muestraUnMensajeQueInformaElNftNoSeEncontro() {
        body= response.getBody().asString();
        response.body();
        //System.out.println(response.contentType());
        System.out.println(body);
    }
}
