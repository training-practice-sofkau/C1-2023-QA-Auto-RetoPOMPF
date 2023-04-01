package com.sofkau.stepDefinitionMarvel;

import com.sofkau.setup.ConstantSetup;
import com.sofkau.setup.WebUIMarvel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;


public class MarvelCharacterIdComicStepDef extends WebUIMarvel {

    public static Logger LOGGER= Logger.getLogger(MarvelCharacterIdComicStepDef.class);

    protected Response response;

    @Given("que tengo acceso a la API de Marvel con credenciales validas")
    public void queTengoAccesoALaAPIDeMarvelConCredencialesValidas() {
    }
    @Given("he obtenido el ID un personaje de Marvel")
    public void heObtenidoElIDUnPersonajeDeMarvel() {

        LOGGER.info("Iniciando la automatizacion...");

    }
    @When("realizo una solicitud de la informacion especifica")
    public void realizoUnaSolicitudDeLaInformacionEspecifica() {
        response = RestAssured.given().get(ConstantSetup.MARVEL_API_URL + "/characters/1011334/comics?apikey=" + ConstantSetup.MARVEL_API_KEY + "&ts=" + ConstantSetup.MARVEL_API_TS + "&hash=" + ConstantSetup.MARVEL_API_HASH).thenReturn();

    }
    @Then("la respuesta deberia incluir una lista de comics")
    public void laRespuestaDeberiaIncluirUnaListaDeComics() {
        try {

            String responseBody = response.getBody().asString();
            LOGGER.info(responseBody);
            Assert.assertEquals(200, response.getStatusCode());
            Assert.assertTrue(responseBody.contains("comics"));

            JsonPath jsonPathEvaluator = new JsonPath(responseBody);
            List<String> comics = jsonPathEvaluator.getList("data.results.title");
            Assert.assertFalse(comics.isEmpty());

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
