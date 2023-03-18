package com.sofkau.stepdefinitions;

import com.sofkau.pages.AlojamientosChromePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class AlojamientosChromeStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(AlojamientosChromeStepDefinition.class);
    @Given("que estoy en la pagina de despegar con {string}")
    public void queEstoyEnLaPaginaDeDespegarCon(String navegador) {
        generalSetup(navegador);
        LOGGER.info("Iniciando automatizacion");
    }
    @Given("que necesito un alojamiento para mi viaje")
    public void queNecesitoUnAlojamientoParaMiViaje() {
        AlojamientosChromePage alojamientosChromePage = new AlojamientosChromePage(super.driver);
        alojamientosChromePage.navigateToAlojamientos();
    }
    @When("seleccione las habitacion llenando los formularios")
    public void seleccioneLasHabitacionLlenandoLosFormularios() {

    }
    @Then("debe observar que el vuelo se ha reservado exitosamente")
    public void debeObservarQueElVueloSeHaReservadoExitosamente() {

    }

    @Given("Tengo {int} personas en el viaje")
    public void tengoPersonasEnElViaje(Integer int1) {

    }
    @When("busque una sola habitacion para hospedarse")
    public void busqueUnaSolaHabitacionParaHospedarse() {

    }
    @Then("debo obtener un mensaje de no disponibilidad")
    public void deboObtenerUnMensajeDeNoDisponibilidad() {
        quiteDriver();
    }

}
