package com.sofkau.stepdefinitions;


import com.sofkau.setup.WebUi;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;


import java.util.logging.Logger;


public class servicesStepDefinition extends WebUi {

    private Response res;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(servicesStepDefinition.class));
    JSONObject resBody = null;
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = null;
    @Given("que tengo acceso a la API de CoinGecko")
    public void queTengoAccesoALaAPIDeCoinGecko() {
        RestAssured.baseURI = "https://api.coingecko.com/";
        setUplog4j();
    }
    @When("hago una peticion GET al endpoint que lista NFTS")
    public void hagoUnaPeticionGETAlEndpointQueListaNFTS() {
        res = RestAssured.given().when().contentType(ContentType.JSON).get("api/v3/nfts/list");
    }
    @Then("la respuesta debe ser un codigo de estado doscientos OKK")
    public void laRespuestaDebeSerUnCodigoDeEstadoDoscientosOKK() {
        try {
            Assertions.assertEquals(200, res.getStatusCode());
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("el cuerpo de la respuesta debe incluir un objeto JSON con la lista de NFTs disponiblesy su informacion")
    public void elCuerpoDeLaRespuestaDebeIncluirUnObjetoJSONConLaListaDeNFTsDisponiblesySuInformacion() {
        System.out.println("Probando");
        try {
            jsonArray = (JSONArray) parser.parse(res.getBody().asString());
            resBody = (JSONObject) jsonArray.get(0);
            Assertions.assertEquals("squiggly", resBody.get("id"));
            Assertions.assertEquals("0x36F379400DE6c6BCDF4408B282F8b685c56adc60", resBody.get("contract_address"));
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    private String assetPlatformId;
    @Given("que tengo acceso a la API de CoinGecko y tengo el id de la blockchain a filtrar")
    public void queTengoAccesoALaAPIDeCoinGeckoYTengoElIdDeLaBlockchainAFiltrar() {
        RestAssured.baseURI = "https://api.coingecko.com/";
        setUplog4j();
    }
    @When("hago una peticion GET al endpoint que lista con el parametro de {string} para filtrar")
    public void hagoUnaPeticionGETAlEndpointQueListaConElParametroDeParaFiltrar(String string) {
        assetPlatformId = string;
        res = RestAssured.given().when().contentType(ContentType.JSON).get("api/v3/nfts/list?asset_platform_id="+assetPlatformId);
    }
    @Then("la respuesta debe ser un codigo de estado doscientos OK")
    public void laRespuestaDebeSerUnCodigoDeEstadoDoscientosOK() {
        try {
            Assertions.assertEquals(200, res.getStatusCode());
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("el cuerpo de la respuesta debe incluir un objeto json que contenga los nfts filtrados")
    public void elCuerpoDeLaRespuestaDebeIncluirUnObjetoJsonQueContengaLosNftsFiltrados() {
        try {
            jsonArray = (JSONArray) parser.parse(res.getBody().asString());
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
        resBody = (JSONObject) jsonArray.get(0);
        Assertions.assertEquals(assetPlatformId, resBody.get("asset_platform_id"));
        Assertions.assertNotNull(resBody.get("id"));
        Assertions.assertNotNull(resBody.get("contract_address"));
    }
}
