package com.sofkau.stepDefinitionMarvel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class MarvelCharacterIdComicStepDef {

    public static Logger LOGGER= Logger.getLogger(MarvelCharacterIdComicStepDef.class);

    protected Response response;

    @Given("que tengo acceso a la API de Marvel con credenciales validas")
    public void queTengoAccesoALaAPIDeMarvelConCredencialesValidas() {

    }
    @Given("he obtenido el ID un personaje de Marvel")
    public void heObtenidoElIDUnPersonajeDeMarvel() {

    }
    @When("realizo una solicitud de la informacion especifica")
    public void realizoUnaSolicitudDeLaInformacionEspecifica() {
        response = RestAssured.get("http://gateway.marvel.com/v1/public/characters/1011334/comics?apikey=519be85584de1be15e49e05d435430d6&ts=1&hash=5dcd64e699b6a72f1e891978296aba78");

    }
    @Then("la respuesta deberia incluir una lista de comics")
    public void laRespuestaDeberiaIncluirUnaListaDeComics() {
        try {
            Assert.assertEquals(200, response.getStatusCode());
            String responseBody = response.getBody().asString();
            LOGGER.info(responseBody);
            Assert.assertTrue(responseBody.contains("comics"));
            LOGGER.info("La prueba paso exitosamente.");
        } catch (AssertionError e) {
            LOGGER.error("La prueba fallo. Error: {}" + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Ocurrio un error durante la ejecución de la prueba. Error: {}" + e.getMessage());
            throw e;
        }

    }
}
