package com.sofkau.stepdefinitions;

import com.sofkau.pages.AlojamientosChromePage;
import com.sofkau.pages.CommonActionsOnPages;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class AlojamientosChromeStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(AlojamientosChromeStepDefinition.class);

    //Scenario 1
    @Given("que estoy en la pagina de despegar con {string}")
    public void queEstoyEnLaPaginaDeDespegarCon(String navegador) {
        generalSetup(navegador);
        LOGGER.info("Iniciando automatizacion");
    }
    @Given("que necesito un alojamiento para mi viaje a {string}")
    public void queNecesitoUnAlojamientoParaMiViajea(String destino) {
        AlojamientosChromePage alojamientosChromePage = new AlojamientosChromePage(super.driver);
        alojamientosChromePage.navigateToAlojamientos();
        alojamientosChromePage.fillDestiny(destino);
    }
    @When("seleccione las habitacion llenando los formularios")
    public void seleccioneLasHabitacionLlenandoLosFormularios() {
            AlojamientosChromePage alojamientosChromePage = new AlojamientosChromePage(super.driver);
            alojamientosChromePage.fillDateEntry();
            alojamientosChromePage.fillDateExit();
            alojamientosChromePage.selectHabitaciones();
    }
    @Then("debe observar que el alojamiento se ha reservado exitosamente")
    public void debeObservarQueElAlojamientoSeHaReservadoExitosamente() {

    }

    //Scenario 2
    @Given("Tengo {int} personas en el viaje")
    public void tengoPersonasEnElViaje(Integer int1) {
        //AlojamientosChromePage alojamientosChromePage = new AlojamientosChromePage(super.driver);
        //alojamientosChromePage.navigateToAlojamientos();
    }
    @When("busque una sola habitacion para hospedarse")
    public void busqueUnaSolaHabitacionParaHospedarse() {

    }
    @Then("debo obtener un mensaje de no disponibilidad")
    public void deboObtenerUnMensajeDeNoDisponibilidad() {
        quiteDriver();
    }

}
