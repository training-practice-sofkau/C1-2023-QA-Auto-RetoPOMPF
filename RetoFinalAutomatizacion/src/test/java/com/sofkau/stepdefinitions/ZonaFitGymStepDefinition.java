package com.sofkau.stepdefinitions;

import com.sofkau.models.Cliente;
import com.sofkau.pages.Page;
import com.sofkau.pages.PageSnacks;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitSnacksStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);
    Cliente cliente = new Cliente();
    //Scenario 1
    @Given("que el usuario se encuentra la pagina principal desde el {string}")
    public void queElUsuarioSeEncuentraLaPaginaPrincipalDesdeEl(String navegador) {
        try {
            if (navegador.equals("chrome")) {
                generalSetUpChrome();
                LOGGER.info("inicio de la automatizacion en chrome ");
            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("inicio de la automatizacion en edge ");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("agrega productos de la categoria snacks al carrito")
    public void agregaProductosDeLaCategoriaSnacksAlCarrito() {
        try {
            PageSnacks pageSnacks = new PageSnacks(super.driver, cliente);
            pageSnacks.agregarProductos();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("completa la informacion necesaria de envio y facturacion")
    public void completaLaInformacionNecesariaDeEnvioYFacturacion() {

    }
    @Then("debera recibir un mensaje de confirmacion de la compra")
    public void deberaRecibirUnMensajeDeConfirmacionDeLaCompra() {

    }

    //Scenario 2

    @When("ingresa informacion imcompleta")
    public void ingresaInformacionImcompleta() {

    }
    @Then("debera recibir un mensaje pidiendo la informacion requerida")
    public void deberaRecibirUnMensajePidiendoLaInformacionRequerida() {

    }

}
