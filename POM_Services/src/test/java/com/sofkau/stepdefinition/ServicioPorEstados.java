package com.sofkau.stepdefinition;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.setup.SetUpConstantes.COVID_ESTADOS;

public class ServicioPorEstados {
    public static Logger LOGGER = Logger.getLogger(ServicioPorEstados.class);
    Response response;
    @Given("El reportero esta en la pagina")
    public void elReporteroEstaEnLaPagina() {
        LOGGER.info("Inicio de la automatizacion COVID posts");
    }
    @When("hace la peticion al servicio por estados")
    public void haceLaPeticionAlServicioPorEstados() {
        response=RestAssured.get(COVID_ESTADOS);
    }
    @Then("recibe una lista con los reportes por estados")
    public void recibeUnaListaConLosReportesPorEstados() {
        Gson gson = new Gson();
        JsonArray responses = new JsonArray();
        JsonElement element;
        JsonArray jsonArray;
        JsonObject jsonObject;
        try{
            Assertions.assertEquals(200, response.statusCode());
            element = gson.fromJson(response.getBody().asString(), JsonElement.class);
            if (element.isJsonArray()) {
                jsonArray = element.getAsJsonArray();
                for (JsonElement jsonElement : jsonArray) {
                    jsonObject = jsonElement.getAsJsonObject();
                    responses.add(jsonObject);
                }
            }
            Assertions.assertTrue(responses.size()>0);
            Assertions.assertEquals("AL",responses.get(1).getAsJsonObject().get("state").getAsString());
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            LOGGER.info("| Esperado | Obtenido | Valor |");
            if (200==response.statusCode()) {
                LOGGER.info("| 200 | " + response.statusCode() + " | Cumple |");
                LOGGER.info("| AL | " + responses.get(1).getAsJsonObject().get("state").getAsString() + " | Cumple |");
            }else {
                LOGGER.info("| 200 | " + response.statusCode() + " | No cumple |");
                LOGGER.info("| AL | " + responses.get(1).getAsJsonObject().get("state").getAsString() + " | Cumple |");
            }
        }
    }
}
