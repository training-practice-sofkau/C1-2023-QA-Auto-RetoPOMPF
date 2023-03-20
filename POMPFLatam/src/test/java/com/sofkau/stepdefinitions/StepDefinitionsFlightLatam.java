package com.sofkau.stepdefinitions;

import com.sofkau.pages.FlightPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class StepDefinitionsFlightLatam extends WebUI {
    public static Logger LOGGER = Logger.getLogger(StepDefinitionsFlightLatam.class);
    public static final String MESSAGE = "Si ya eres parte de LATAM, ingresa tus datos:";


    @Given("el usuario ingresa a la pagina web de Latam")
    public void elUsuarioIngresaALaPaginaWebDeLatam() {
        generalSetUp();
        LOGGER.info("Inicio de la automatizacion");
    }

    @When("diligencia el formulario con Medellin y Cali como ciudades de origen y destino")
    public void diligenciaElFormularioConMedellinYCaliComoCiudadesDeOrigenYDestino() throws InterruptedException {
        LOGGER.info("Scenario: Vuelo MDE-CLO");
        FlightPage flightPage = new FlightPage(super.driver);
        flightPage.fillFieldsFlightOne();
    }
    @Then("retorna un mensaje con el resumen de la informacion de los vuelos")
    public void retornaUnMensajeConElResumenDeLaInformacionDeLosVuelos() throws InterruptedException {
        FlightPage flightPage = new FlightPage(super.driver);
        Assertions.assertEquals(MESSAGE, flightPage.getElementText());
        LOGGER.info(flightPage.getElementText());
        Assertions.assertNotNull(flightPage.getElementText());
    }


}
