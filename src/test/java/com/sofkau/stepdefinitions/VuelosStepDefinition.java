package com.sofkau.stepdefinitions;

import com.sofkau.pages.VuelosPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class VuelosStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(VuelosStepDefinition.class);

    //Scenario 1
    @Given("que estoy en la pagina de despegar con el navegador {string}")
    public void queEstoyEnLaPaginaDeDespegarConElNavegador(String navegador) {
        generalSetup(navegador);
        LOGGER.info("Iniciando automatizacion");
    }
    @Given("que necesito un vuelo con origen {string} y destino {string}")
    public void queNecesitoUnVueloConOrigenYDestino(String origen, String destino) throws InterruptedException {
        VuelosPage vuelosPage = new VuelosPage(super.driver);
        vuelosPage.navigateToVuelos();
        vuelosPage.selectOriginDestiny(origen, destino);
    }
    @When("seleccione el vuelo mas barato disponible")
    public void seleccioneElVueloMasBaratoDisponible() {
        VuelosPage vuelosPage = new VuelosPage(super.driver);
        vuelosPage.buscarVuelo();
        vuelosPage.fillForm();
    }
    @Then("debe observar que el vuelo se ha reservado exitosamente")
    public void debeObservarQueElVueloSeHaReservadoExitosamente() {

    }

    //Scenario 1
    @Given("que necesito un alojamiento para mi viaje a {string}")
    public void queNecesitoUnAlojamientoParaMiViajea(String destino) {
        VuelosPage alojamientosChromePage = new VuelosPage(super.driver);
        //alojamientosChromePage.navigateToAlojamientos();
        //alojamientosChromePage.fillDestiny(destino);
    }
    @When("seleccione las habitacion llenando los formularios")
    public void seleccioneLasHabitacionLlenandoLosFormularios() throws InterruptedException {
            //AlojamientosChromePage alojamientosChromePage = new AlojamientosChromePage(super.driver);
            //alojamientosChromePage.fillDateEntry();
            //alojamientosChromePage.fillDateExit();
            //alojamientosChromePage.selectHabitaciones();
    }
    @Then("debe observar que el alojamiento se ha reservado exitosamente")
    public void debeObservarQueElAlojamientoSeHaReservadoExitosamente() {

    }

}
