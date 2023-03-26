package com.sofkau.stepdefinitions;

import com.sofkau.models.Facturacion_Envio;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import com.sofkau.pages.FormPage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlujoDeCompraStepDefinition extends WebUI {
    Facturacion_Envio facturacion_envio = new Facturacion_Envio();
    public static Logger LOGGER = Logger.getLogger(IniciarSesionOutlineStepDefinition.class);
    @Given("estoy en la pagina principal de ZonaFit usando {string}")
    public void estoyEnLaPaginaPrincipalDeZonaFitUsando(String navegador) {

        try {
            if (navegador.equals("chrome")){
                generalSetUpChrome();
                LOGGER.info("Inicio de la Automatizacion");

            } else if (navegador.equals("edge")) {
                generalSetUpEdge();
                LOGGER.info("Inicio de la Automatizacion");
            }

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }



        FormPage formPage= new FormPage( super.driver,facturacion_envio);
    }


    @When("selecciono y anado productos al carrito de compras")
    public void seleccionoYAnadoProductosAlCarritoDeCompras() {
        FormPage formPage = new FormPage(super.driver,facturacion_envio);
        formPage.DatosFacturacionn();
        formPage.agregar();
        formPage.facturacion();

    }
    @When("ingreso mis datos personales y el metodo de pago")
    public void ingresoMisDatosPersonalesYElMetodoDePago() {


    }
    @Then("debo ver un mensaje de confirmacion de compra exitosa.")
    public void deboVerUnMensajeDeConfirmacionDeCompraExitosa() {
        try {

            String MensajeEsperado="Gracias. Tu pedido ha sido recibido.";
            FormPage formPage = new FormPage(super.driver,facturacion_envio);
            String Mensajeactual= formPage.getMensajeFinal(driver).getText();

            assertEquals(MensajeEsperado,Mensajeactual);
            LOGGER.info("mensaje esperado:"+MensajeEsperado);
            LOGGER.info("mensaje actual:"+Mensajeactual);


        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(), exception);
            LOGGER.error("la asercion no cumple");
}

    }

}
