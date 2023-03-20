package com.sofkau.stepdefinitions;


import com.sofkau.pages.LatamPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


import org.apache.log4j.Logger;

public class LatamStepDefinition extends WebUi {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(LatamStepDefinition.class));

    @Given("que estoy en la pagina principal de latam usando el {string}")
    public void queEstoyEnLaPaginaPrincipalDeLatamUsandoEl(String navegador) {
        if(navegador.equals("chrome")){
            generalSetupChrome();
        } else if (navegador.equals("edge")) {
            generalSetupEdge();
        }
    }
    @When("realizo todo el flujo de compra para {int} adultos saliendo desde {string} hasta {string} y seleccionando la {string}")
    public void realizoTodoElFlujoDeCompraParaAdultosSaliendoDesdeHastaYSeleccionandoLa(Integer cantidad, String salida, String llegada, String categoria) throws InterruptedException{
        LatamPage latamPage=new LatamPage(super.driver);

        latamPage.paginaPrincipa(cantidad, salida, llegada, categoria);
        latamPage.seleccionarTickets(cantidad,salida,llegada, categoria);
        latamPage.infoPasajeros(cantidad,salida,llegada, categoria);
    }
    @Then("selecciono pago con tarjeta de credito y recibo un mensaje de confirmacion")
    public void seleccionoPagoConTarjetaDeCreditoYReciboUnMensajeDeConfirmacion() {
        try{
            Assertions.assertEquals(LatamPage.confrimarFlujo1,"Ingresa los datos de tu tarjeta");
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage());
        }finally {
            LOGGER.info("Esperaba ver el mensaje: Ingresa los datos de tu tarjeta      Recibio: "+LatamPage.confrimarFlujo1);
            quiteDriver();
        }
    }
}
