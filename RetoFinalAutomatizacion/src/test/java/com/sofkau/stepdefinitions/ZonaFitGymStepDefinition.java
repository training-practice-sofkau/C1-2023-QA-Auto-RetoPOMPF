package com.sofkau.stepdefinitions;

import com.sofkau.models.Cliente;
import com.sofkau.pages.PageGym;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZonaFitGymStepDefinition extends WebUI {
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

    @When("agrega productos de la categoria gym en casa al carrito")
    public void agregaProductosDeLaCategoriaGymEnCasaAlCarrito() {
        try {
            PageGym pageGym = new PageGym(super.driver, cliente);
            pageGym.agregarProductos();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @When("completa la informacion necesaria de envio y facturacion")
    public void completaLaInformacionNecesariaDeEnvioYFacturacion() {
        try {
            setData();
            PageGym pageGym = new PageGym(super.driver, cliente);
            pageGym.fillMandatoryFields();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debera recibir un mensaje de confirmacion de la compra")
    public void deberaRecibirUnMensajeDeConfirmacionDeLaCompra() {
        try {
            String mensajeEsperado = "Gracias. Tu pedido ha sido recibido.";
            PageGym pageGym = new PageGym(super.driver, cliente);
            String mensajeActual = pageGym.getMensajeFinal(driver).getText();
            assertEquals(mensajeEsperado, mensajeActual);
            LOGGER.info("VALOR ESPERADO:" + mensajeEsperado);
            LOGGER.info("VALOR OBTENIDO" + mensajeActual);

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);

        }
    }

    //Scenario 2

    @When("ingresa informacion imcompleta")
    public void ingresaInformacionImcompleta() {
        try {
            setData();
            PageGym pageGym = new PageGym(super.driver, cliente);
            pageGym.fillMandatoryFields2();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("debera recibir un mensaje pidiendo la informacion requerida")
    public void deberaRecibirUnMensajePidiendoLaInformacionRequerida() {

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
