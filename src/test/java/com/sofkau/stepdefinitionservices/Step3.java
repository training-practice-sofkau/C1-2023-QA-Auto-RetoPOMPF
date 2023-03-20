package com.sofkau.stepdefinitionservices;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Step3 extends WebUI {

    private final Logger logger = LoggerFactory.getLogger(Step3.class);
    private Response response;
    private JSONArray jsonArray;

    @Given("que el usuario tiene acceso al servicio de COVID Tracking API")
    public void que_el_usuario_tiene_acceso_al_servicio_de_covid_tracking_api() {
        RestAssured.baseURI = "https://api.covidtracking.com";
    }

    @When("el usuario solicita los datos de hospitalizaciones diarias en Estados Unidos")
    public void QueElUsuarioTieneAccesoAlServicioDeCovidTrackingApi() {
        response = RestAssured.get("/v1/us/daily.json");
        logger.info("Response: " + response.prettyPrint());
    }

    @Then("el servicio responde con un codigo de respuesta {int}")
    public void ElServicioRespondeConUnCodigoDeRespuesta(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(Integer.valueOf(expectedStatusCode), Integer.valueOf(actualStatusCode));
        logger.info("Status code: " + actualStatusCode);
    }

    @Then("el servicio responde con datos de hospitalizaciones diarias validos")
    public void ElServicioRespondeConDatosDeHospitalizacionesDiariasValidos() throws ParseException {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(responseBody);
        int hospitalizedCount = 0;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject dailyData = (JSONObject) jsonArray.get(i);
            if (dailyData.get("hospitalizedCurrently") != null) {
                hospitalizedCount = ((Long) dailyData.get("hospitalizedCurrently")).intValue();
            }
        }
        Assert.assertTrue(hospitalizedCount >= 0);
        Assert.assertEquals(325, hospitalizedCount);
    }
}
