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


    //navegador Edge

   @Given("el usuario esta en la pagina registro de vuelo con navegador {string}")
    public void el_usuario_esta_en_la_pagina_registro_de_vuelo_con_navegador(String navegador2) {
      // generalSetup(navegador2);
     //  LOGGER.warn("Inicio de la Automatizacion");
    }
    @When("selecciona lugar origen y de destino de llegada")
    public void selecciona_lugar_origen_y_de_destino_de_llegada() throws InterruptedException {
    /*    VueloFormPage vueloFormPage = new VueloFormPage(super.driver);
        vueloFormPage.fillMandatoryFields();
        vueloFormPage.closeLogin();
        vueloFormPage.filtrarOrigen("Medellin");
        vueloFormPage.filtrarDestino("Pereira");
*/
    }
    @Then("deberia obtener un mensaje de confirmacion de la reserva de la web")
    public void deberia_obtener_un_mensaje_de_confirmacion_de_la_reserva_de_la_web() {
    /*    VueloFormPage vueloFormPage = new VueloFormPage(super.driver);
        String esperadoMensaje = "\u00A1Genial! Ahora solo te falta realizar el pago.";
        String mensajeActual = vueloFormPage.verMensajeFinal();
        Assert.assertEquals(esperadoMensaje,mensajeActual);
        LOGGER.info("La prueba ha pasado" + mensajeActual);
        quiteDriver();
*/
    }


}
