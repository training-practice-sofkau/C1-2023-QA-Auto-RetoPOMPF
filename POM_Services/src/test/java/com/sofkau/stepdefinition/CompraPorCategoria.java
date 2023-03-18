package com.sofkau.stepdefinition;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;

public class CompraPorCategoria extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("Estoy en la pagina principal de zona fit en el {string}")
    public void estoyEnLaPaginaPrincipalDeZonaFitEnEl(String string) {
        generalSetUp(string);
        LOGGER.info("Se inicia la automatizacion");
    }
    @When("Pongo el mouse sobre el boton categoria y escojo la opcion proteinas limpias")
    public void pongoElMouseSobreElBotonCategoriaYEscojoLaOpcionProteinasLimpias() {

    }
    @When("escojo los productos que deseo llevar y modifico su cantidad")
    public void escojoLosProductosQueDeseoLlevarYModificoSuCantidad() {

    }
    @When("Doy click en finalizar compra y hago el proceso hasta el pago")
    public void doyClickEnFinalizarCompraYHagoElProcesoHastaElPago() {

    }
    @Then("Redirige a la pagina final en donde nos indica el numero de convenio")
    public void redirigeALaPaginaFinalEnDondeNosIndicaElNumeroDeConvenio() {
        quitDriver();
    }
}
