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
public class ServicioPorDia {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("El reportero esta en la pagina")
    public void elReporteroEstaEnLaPagina() {
    }
    @When("hace la peticion al servicio diario")
    public void haceLaPeticionAlServicioDiario() {
    }
    @Then("recibe una lista con los reportes diarios")
    public void recibeUnaListaConLosReportesDiarios() {
    }
}
