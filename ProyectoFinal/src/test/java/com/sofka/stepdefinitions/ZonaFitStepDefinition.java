package com.sofka.stepdefinitions;

import com.sofka.models.ClienteZonaFit;
import com.sofka.pages.CommonActionOnPage;
import com.sofka.pages.InicioSesionPage;
import com.sofka.pages.LocatorPage;
import com.sofka.pages.NewsLetterPage;
import com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(ZonaFitStepDefinition.class);
    ClienteZonaFit clienteZonaFit = new ClienteZonaFit();

    private LocatorPage locatorPage;

    @Given("que el cliente se encuentra en la pagina principal con {string}")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalCon(String navegador) {

        try{
            if (navegador.equals("chrome")){
                generalSetUpGoogleChrome();
                LOGGER.info("Inicia la automatización");
            } else if (navegador.equals("edge")){
                generalSetUpMicrosoftEdge();
                LOGGER.info("Inicia la automatización");
            }
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @When("agrega varios productos al carrito")
    public void agregaVariosProductosAlCarrito() {
        try{
            locatorPage = new LocatorPage(super.driver, clienteZonaFit);
            locatorPage.navegar();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @When("completa la informacion del formulario de facturacion")
    public void completaLaInformacionDelFormularioDeFacturacion() {
        try{
            clienteZonaFit.setDocumentNumber("43019745");
            clienteZonaFit.setEmail("ganoxo6430@huvacliq.com");
            clienteZonaFit.setName("Gabriela");
            clienteZonaFit.setLastName("Montoya");
            clienteZonaFit.setDepartment("Caldas");
            clienteZonaFit.setCity("Manizales");
            clienteZonaFit.setAddress("Cll 46 B#78-12");
            clienteZonaFit.setAddress2("Casa 2do piso");
            clienteZonaFit.setPhoneNumber("3116547101");

            locatorPage.formBill();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @Then("mostrara un mensaje confirmando la compra")
    public void mostraraUnMensajeConfirmandoLaCompra() {
        try{
            String expectedMessage = "CONVENIO RECAUDO ZONA FIT - BALOTO";
            locatorPage = new LocatorPage(super.driver, clienteZonaFit);
            String currentMessage = locatorPage.getConfirmationMessage(driver).getText().trim().replaceAll("[^a-zA-Z0-9]","");
            Assertions.assertEquals(expectedMessage.replaceAll("[^a-zA-Z0-9]",""), currentMessage);
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(),exception);
        }
    }

    @When("completa un campo con un dato invalido")
    public void completaUnCampoConUnDatoInvalido() {
        try{
            clienteZonaFit.setDocumentNumber("10312548");
            clienteZonaFit.setEmail("ganoxo6430");
            clienteZonaFit.setName("Gabriela");
            clienteZonaFit.setLastName("Montoya");
            clienteZonaFit.setDepartment("Caldas");
            clienteZonaFit.setCity("Manizales");
            clienteZonaFit.setAddress("Cll 46 B#78-12");
            clienteZonaFit.setAddress2("Casa 2do piso");
            clienteZonaFit.setPhoneNumber("3116547101");

            locatorPage.formBillFailed();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @Then("mostrara un mensaje de error indicando el campo obligatorio al ingresar un dato invalido")
    public void mostraraUnMensajeDeErrorIndicandoElCampoObligatorioAlIngresarUnDatoInvalido() {
       /**
        try{
            String expectedMessage = "CONVENIO RECAUDO ZONA FIT - BALOTO";
            locatorPage = new LocatorPage(super.driver, clienteZonaFit);
            String currentMessage = locatorPage.getConfirmationMessage(driver).getText().trim().replaceAll("[^a-zA-Z0-9]","");
            Assertions.assertEquals(expectedMessage.replaceAll("[^a-zA-Z0-9]",""), currentMessage);
        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(),exception);
        }
        */
    }
}