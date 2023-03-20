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

    private static final Logger LOGGER = Logger.getLogger(FlujoCompra.class);
    private FlujoCompra compra;
    public FormModel cliente;

    //Background
    @Given("que el cliente se encuentra en la pagina principal de la tienda zonafit")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalDeLaTiendaZonafit() {
        try {
            generalSetUp();
        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    //Escenario 1
    @When("el cliente selecciona los producto y ingresa la informacion requerida dejando como medio de pago la opcion baloto")
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
    @Then("el sistema debera mostrar la pagina de confirmacion de compra")
    public void elSistemaDeberaMostrarLaPaginaDeConfirmacionDeCompra() {
        String expectedText = "Pedido Completado";
        try {
            WebElement heading = driver.findElement(By.xpath("(//h2[text()='" + expectedText + "'])"));
            Assertions.assertEquals(expectedText, heading.getText(), "El texto es diferente. Valor esperado: " + expectedText + " Valor actual: " + heading.getText());
            LOGGER.info("La aserción se cumple correctamente");
            validacionPedido();
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
    //Escenario 2
    @When("el cliente selecciona los productos y ingresa la informacion requerida dejando como medio de pago la opcion efecty")
    public void elClienteSeleccionaLosProductosYIngresaLaInformacionRequeridaDejandoComoMedioDePagoLaOpcionEfecty() {

        try {
            clienteGeneral();
            FlujoCompra compra = new FlujoCompra(cliente, driver);
            compra.llenarInformacion2();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @Then("el sistema debera muestra un mensaje de la confirmacion de la compra")
    public void elSistemaDeberaMuestraUnMensajeDeLaConfirmacionDeLaCompra() {

        try {
            Assertions.assertEquals("Número de Convenio",
                    "Número de Convenio", "El texto es diferente");
            validacionPedido();

        } catch (Exception exception) {
            quitDriver();
            Assertions.fail(exception.getMessage(), exception);
        }
    }
}
