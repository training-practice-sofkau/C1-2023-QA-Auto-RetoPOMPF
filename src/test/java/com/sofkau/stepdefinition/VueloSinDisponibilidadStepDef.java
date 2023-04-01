package com.sofkau.stepdefinition;

import com.sofkau.pages.VueloNoDisponiblePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static org.python.util.jython.logger;

public class VueloSinDisponibilidadStepDef extends WebUI {

    public static Logger LOGGER=Logger.getLogger(VueloSinDisponibilidadStepDef.class);

    private Response response;

    @Given("que estoy en la pagina principal de Despegar.com.co en el navegador {string}")
    public void queEstoyEnLaPaginaPrincipalDeDespegarComCo(String navegadorSelect) {
        generalSetUp(navegadorSelect);
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("busco y selecciono un vuelo de ida y vuelta desde origen a destino para tres adultos")
    public void buscoYSeleccionoUnVueloDeIdaYVueltaDesdeOrigenADestinoParaTresAdultos() throws InterruptedException {
        VueloNoDisponiblePage vueloNoDisponiblePage = new VueloNoDisponiblePage(super.driver);
        vueloNoDisponiblePage.clickVuelo();
        vueloNoDisponiblePage.fillMandatoryFields();

    }
    @Then("veo un mensaje indicando que No hay vuelos disponibles en las rutas elegida en primera clase")
    public void veoUnMensajeIndicandoQueNoHayVuelosDisponiblesEnLasRutasElegidaEnPrimeraClase() {

        VueloNoDisponiblePage vueloNoDisponiblePage = new VueloNoDisponiblePage(super.driver);

        try {
            String expectedMessage = "No hay vuelos disponibles en estas fechas";
            String actualMessage = vueloNoDisponiblePage.verMensaje();
            logger.info(actualMessage);

            Assert.assertEquals(expectedMessage, actualMessage);
            logger.info("La prueba ha pasado. Se encontro el mensaje esperado: " + actualMessage);

        } catch (AssertionError e) {
            LOGGER.error("La prueba fallo. Error: " + e.getMessage());
            quiteDriver();
            throw e;
        } catch (Exception e) {
            LOGGER.error("Ocurrio un error durante la ejecucion de la prueba. Error: " + e.getMessage());
            quiteDriver();
            throw e;
        } finally {
            quiteDriver();
        }

    }
}
