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
    public void el_usuario_solicita_los_datos_de_hospitalizaciones_diarias_en_estados_unidos() {
        response = RestAssured.get("/v1/us/daily.json");
        logger.info("Response: " + response.prettyPrint());
    }

    @Then("el servicio responde con un codigo de respuesta {int}")
    public void el_servicio_responde_con_un_codigo_de_respuesta(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(Integer.valueOf(expectedStatusCode), Integer.valueOf(actualStatusCode));
        logger.info("Status code: " + actualStatusCode);
    }

    @Then("el servicio responde con datos de hospitalizaciones diarias validos")
    public void el_servicio_responde_con_datos_de_hospitalizaciones_diarias_validos() throws ParseException {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(responseBody);

        // Find the latest dateChecked field value
        String latestDateChecked = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject dailyData = (JSONObject) jsonArray.get(i);
            if (dailyData.get("dateChecked") != null) {
                latestDateChecked = (String) dailyData.get("dateChecked");
                break;
            }
        }

        // Find the hospitalizedCurrently value for the latest dateChecked
        int hospitalizedCount = 0;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject dailyData = (JSONObject) jsonArray.get(i);
            if (dailyData.get("dateChecked") != null && dailyData.get("dateChecked").equals(latestDateChecked)) {
                hospitalizedCount = ((Long) dailyData.get("hospitalizedCurrently")).intValue();
                break;
            }
        }

        // Perform assertion on the hospitalized count for the latest dateChecked
        Assert.assertTrue(hospitalizedCount >= 0);
        Assert.assertEquals(40199, hospitalizedCount); // Replace with the expected hospitalized count for the latest dateChecked
    }

}
