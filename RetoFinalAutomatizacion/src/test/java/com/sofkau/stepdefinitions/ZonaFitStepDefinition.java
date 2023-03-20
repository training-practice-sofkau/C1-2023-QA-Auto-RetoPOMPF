package com.sofkau.stepdefinitions;

import com.sofkau.models.Cliente;
import com.sofkau.pages.Page;
import com.sofkau.pages.PageGym;
import com.sofkau.setup.WebUI;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.function.Try;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZonaFitStepDefinition extends WebUI {

    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);
    Cliente cliente = new Cliente();

    //Scenario 1
    @Given("que el cliente esta en la pagina principal desde el {string}")
    public void queElClienteEstaEnLaPaginaPrincipalDesdeEl(String navegador) {
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
    @When("agrega productos al carrito")
    public void agregaProductosAlCarrito() {
        try {
            Page page = new Page(super.driver, cliente);
            page.agregarProductos();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("completa la informacion de envio y facturacion")
    public void completaLaInformacionDeEnvioYFacturacion() {
        try {
            setData();
            Page page = new Page(super.driver, cliente);
            page.fillMandatoryFields();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debera observar un mensaje de confirmacion de la compra")
    public void deberaObservarUnMensajeDeConfirmacionDeLaCompra() {
        try {
            String mensajeEsperado = "Gracias. Tu pedido ha sido recibido.";
            Page page = new Page(super.driver, cliente);
            String mensajeActual = page.getMensajeFinal(driver).getText();
            assertEquals(mensajeEsperado, mensajeActual);
            LOGGER.info("VALOR ESPERADO: " + mensajeEsperado);
            LOGGER.info("VALOR OBTENIDO: " + mensajeActual);

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);

        }

    }


    public void setData() {
        cliente.setDocument("190845364");
        cliente.setEmail("pedroperez@gmail.com");
        cliente.setName("pedro");
        cliente.setLastName("perez");
        cliente.setDepartment("Norte de Santander");
        cliente.setCity("Cucuta");
        cliente.setAddress("Av 4 # 16-16");
        cliente.setPhone("3101234567");

    }
}
