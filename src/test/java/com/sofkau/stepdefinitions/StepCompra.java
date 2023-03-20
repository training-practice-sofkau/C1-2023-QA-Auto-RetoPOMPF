package com.sofkau.stepdefinitions;

import com.sofkau.pages.FlujoCompra;
import com.sofkau.setup.WebUI;
import com.sofkau.models.FormModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.sofkau.pages.FlujoCompra.validacionPedido;

public class StepCompra extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(StepCompra.class);
    public FormModel cliente;

    //Background
    @Given("Que el cliente se encuentra en la pagina principal de la tienda zonafit")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalDeLaTiendaZonafit() {
        try {
            generalSetUp();
        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("El cliente selecciona los producto y ingresa la informacion requerida dejando como medio de pago la opcion baloto")
    public void elClienteSeleccionaLosProductoYIngresaLaInformacionRequeridaDejandoComoMedioDePagoLaOpcionBaloto() {
        try {
            clienteGeneral();
            FlujoCompra compra = new FlujoCompra(cliente, driver);
            compra.llenarInformacion1();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("El sistema debera mostrar la pagina de confirmacion de compra")
    public void elSistemaDeberaMostrarLaPaginaDeConfirmacionDeCompra() {
        String expectedText = "Gracias. Tu pedido ha sido recibido.";
        try {
            WebElement heading = driver.findElement(By.xpath("(//strong[normalize-space()='Gracias. Tu pedido ha sido recibido.'])[1]"));
            Assertions.assertEquals(expectedText, heading.getText());
            LOGGER.info("La aserción se cumple correctamente");
            LOGGER.error("Valor esperado: " + expectedText + " Valor actual: " + heading.getText());
            validacionPedido();
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
            LOGGER.error("La aserción no se cumple correctamente");


        }
    }
    //Funciones
    private void clienteGeneral() {
        cliente = new FormModel();
        cliente.setCedula("123456789");
        cliente.setEmail("james@gmail.com");
        cliente.setName("james");
        cliente.setLastName("munoz");
        cliente.setRegion("antioquia");
        cliente.setCity("medellin");
        cliente.setAddress(" Calle 123 # 10-20");
        cliente.setNoAddress(" 101");
        cliente.setPhone("3149999999");
    }
}
