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

import static com.sofkau.setup.SetUpConstantes.COVID_DIARIO;

public class ServicioPorDia {
    public static Logger LOGGER = Logger.getLogger(ServicioPorDia.class);
    private Response response;
    @Given("El reportero esta en la pagina de servicio diario")
    public void elReporteroEstaEnLaPaginaDeServicioDiario() {
        LOGGER.info("Inicio de la automatizacion COVID diaria");
    }
    @When("hace la peticion al servicio diario")
    public void haceLaPeticionAlServicioDiario() {
        response=RestAssured.get(COVID_DIARIO);
    }
    @Then("recibe una lista con los reportes diarios")
    public void recibeUnaListaConLosReportesDiarios() {
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
