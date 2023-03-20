package com.sofkau.stepdefinitions;

import com.sofkau.model.Usuario;
import com.sofkau.pages.VueloFormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class VueloStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(VueloStepDefinition.class);
    private Response response;
    private String requeestBody;
    private Usuario usuario;



    @Given("el usuario esta en la pagina registro de vuelo con {string}")
    public void elUsuarioEstaEnLaPaginaRegistroDeVueloCon(String navegador1) {
        generalSetup(navegador1);
        LOGGER.warn("Inicio de la Automatizacion");
    }
    @When("selecciona lugar origen y de destino")
    public void seleccionaLugarOrigenYDeDestino() throws InterruptedException {
        VueloFormPage vueloFormPage = new VueloFormPage(super.driver);
        vueloFormPage.fillMandatoryFields();
        vueloFormPage.closeLogin();
        vueloFormPage.filtrarOrigen("Medellin");
        vueloFormPage.filtrarDestino("Pereira");
    }


    @Then("deberia obtener un mensaje de confirmacion de la reserva")
    public void deberiaObtenerUnMensajeDeConfirmacionDeLaReserva() {
        VueloFormPage vueloFormPage = new VueloFormPage(super.driver);
        String esperadoMensaje = "\u00A1Genial! Ahora solo te falta realizar el pago.";
        String mensajeActual = vueloFormPage.verMensajeFinal();
        Assert.assertEquals(esperadoMensaje,mensajeActual);
        LOGGER.info("La prueba ha pasado" + mensajeActual);
        quiteDriver();
    }


    //scenario dos

    @Given("el usuario esta en la pagina registro formulario de vuelo {string}")
    public void elUsuarioEstaEnLaPaginaRegistroFormularioDeVuelo(String navegador2) {
       // generalSetup(navegador2);
        //LOGGER.warn("Inicio de la Automatizacion");
    }
    @When("selecciona una fecha no disponible")
    public void seleccionaUnaFechaNoDisponible() {

    }
    @Then("deberia obtener un mensaje vuelos no disponibles")
    public void deberiaObtenerUnMensajeVuelosNoDisponibles() {

    }


}
