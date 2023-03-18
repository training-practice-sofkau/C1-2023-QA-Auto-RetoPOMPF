package com.sofkau.stepdefinition;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;

public class CompraPorCategoria extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("Estoy en la pagina principal de zona fit en el {string}")
    public void estoyEnLaPaginaPrincipalDeZonaFitEnEl(String string) {
        generalSetUp(string);
        LOGGER.info("Se inicia la automatización");
    }
    @When("Pongo el mouse sobre el boton categoria y escojo la opcion proteinas limpias")
    public void pongoElMouseSobreElBotonCategoriaYEscojoLaOpcionProteinasLimpias() {

    }
    @When("escojo los productos que deseo llevar y modifico su cantidad")
    public void escojoLosProductosQueDeseoLlevarYModificoSuCantidad() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Doy click en finalizar compra y hago el proceso hasta el pago")
    public void doyClickEnFinalizarCompraYHagoElProcesoHastaElPago() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Redirige a la pagina final en donde nos indica el número de convenio")
    public void redirigeALaPaginaFinalEnDondeNosIndicaElNúmeroDeConvenio() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
