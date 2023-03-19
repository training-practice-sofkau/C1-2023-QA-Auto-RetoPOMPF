package com.sofkau.stepdefinitions;

import com.sofkau.page.FPageDisneyChrome;
import com.sofkau.page.FPageVuelosChrome;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class StepVuelo extends WebUI {
       public static Logger LOGGER = Logger.getLogger(String.valueOf(StepVuelo.class));
    @Given("que debo llevar tres personas en el viaje por {string}")
    public void que_debo_llevar_tres_personas_en_el_viaje_por(String navegador) {
        generalSetUp(navegador);
        LOGGER.info("Inicio de la Automatizacion");

    }
    @When("seleccione vuelos con  origen")
    public void seleccioneVuelosConOrigen() throws InterruptedException {
        FPageVuelosChrome pageVuelos = new FPageVuelosChrome(super.driver);
        pageVuelos.closeLogin();
        pageVuelos.selectedPage();
        pageVuelos.filtrarOrigen("Medellin");
        pageVuelos.filtrarDestino ("Cali");
        pageVuelos.seleccionarVuelo();
        pageVuelos.llenarFormulario("yoli");
    }
    @Then("debera mostrar un mensaje de reserva exitosa")
    public void deberaMostrarUnMensajeDeReservaExitosa() {

    }
}
