package com.sofkau.stepdefinitions;
import com.sofkau.setup.SetupService;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import static com.sofkau.setup.ConstantSetup.*;
import static io.restassured.RestAssured.when;

public class ServicioGetComicStepDefinition  extends SetupService {

    public static Logger LOGGER = Logger.getLogger(CompraVueloStepDefinition.class);
    private Response respuesta;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    String url = String.format("%s://%s/%s/%s/%s?apikey=%s&ts=%d&hash=%s",
            PROTOCOLO, HOST, IDENTIFICADOR_VERSION, TIPO_LLAVE, TIPO_SERVICIO, LLAVE_API, TS, HASH);


    @Given("que soy el usuario de la API de marvel")
    public void queSoyElUsuarioDeLaAPIDeMarvel() {
        generalSetup();
    }
    @When("se splicita el listado de comics de marvel")
    public void seSplicitaElListadoDeComicsDeMarvel() {
        respuesta = when().get(url);

    }
    @Then("se deberian visualizar todos los comics de marvel")
    public void seDeberianVisualizarTodosLosComicsDeMarvel() {
        try {
            responseBody = (JSONObject) parser.parse(respuesta.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String title = (String) firstResult.get("title");
            System.out.println(title);
            LOGGER.info(title);
            LOGGER.info(data);
            LOGGER.info(results);
            Assertions.assertEquals("Marvel Previews (2017)", title);
            Assertions.assertEquals(respuesta.getStatusCode(), 200);

        }catch (ParseException e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();


        }
    }



// SEGUNDO ESCENARIO

    @Given("que soy un usuario de la API de Marvel Universe e intento obtener todos los comics de Marvel")
    public void queSoyUnUsuarioDeLaAPIDeMarvelUniverseEIntentoObtenerTodosLosComicsDeMarvel() {
        generalSetup();
    }
    @When("se solicita el listado de comics de Marvel y no se envia el parametro de autenticacion")
    public void seSolicitaElListadoDeComicsDeMarvelYNoSeEnviaElParametroDeAutenticacion() {
        respuesta = when().get(url);

    }
    @Then("la API responde error en la solicitud")
    public void laAPIRespondeErrorEnLaSolicitud() {


        try {
            responseBody = (JSONObject) parser.parse(respuesta.getBody().asString());
            JSONObject data = (JSONObject) responseBody.get("data");
            JSONArray results = (JSONArray) data.get("results");
            JSONObject firstResult = (JSONObject) results.get(0);
            String title = (String) firstResult.get("title");
            System.out.println(title);
            LOGGER.info(title);
            LOGGER.info(data);
            LOGGER.info(results);
            Assertions.assertEquals("PetroskyMan", title);
            Assertions.assertEquals(respuesta.getStatusCode(), 200);
            LOGGER.info(respuesta.getStatusCode());
            LOGGER.info(400);


        }catch (ParseException e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();


        }
    }


    }

