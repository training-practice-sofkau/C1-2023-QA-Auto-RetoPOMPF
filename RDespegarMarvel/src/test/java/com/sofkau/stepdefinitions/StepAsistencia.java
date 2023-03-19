package com.sofkau.stepdefinitions;

import com.sofkau.page.FPageAsistenciaChrome;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class StepAsistencia extends WebUI {


    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepAsistencia.class));

    @Given("que necesito asistencia nacional  para cuatro personas en {string}")
    public void queNecesitoAsistenciaNacionalParaCuatroPersonasEn(String navegador) {
        generalSetUp(navegador);
        LOGGER.info("Inicio de la Automatizacion");

    }
    @When("seleccione asistencia nacional e informacion requerida")
    public void seleccioneAsistenciaNacionalEInformacionRequerida() throws InterruptedException {

        FPageAsistenciaChrome pageAsistencia = new FPageAsistenciaChrome(super.driver);
        pageAsistencia.closeLogin();
        pageAsistencia.selectedPage();
        pageAsistencia.fillAssistanceForm();

    }
    @Then("debo obtener un mensaje de reserva de asistencia exitosa")
    public void deboObtenerUnMensajeDeReservaDeAsistenciaExitosa() {

    }


    //Escenario 2
    @Given("que necesito asistencia  para cuatro personas")
    public void queNecesitoAsistenciaParaCuatroPersonas() {

    }
    @When("seleccione asistencia internacional e informacion requerida")
    public void seleccioneAsistenciaInternacionalEInformacionRequerida() {

    }
    @Then("debe observar un mensaje de reserva de asistencia exitosa")
    public void debeObservarUnMensajeDeReservaDeAsistenciaExitosa() {

    }

}
