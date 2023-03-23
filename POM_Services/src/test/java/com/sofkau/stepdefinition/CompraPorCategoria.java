package com.sofkau.stepdefinition;
import com.sofkau.page.FormaDeLaPagina;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CompraPorCategoria extends WebUI{
    public static Logger LOGGER = Logger.getLogger(String.valueOf(CompraPorCategoria.class));
    @Given("Estoy en la pagina principal de zona fit en el {string}")
    public void estoyEnLaPaginaPrincipalDeZonaFitEnEl(String string) {
        generalSetUp(string);
        LOGGER.info("Se inicia la automatizacion");
    }
    @When("Pongo el mouse sobre el boton categoria y escojo la opcion proteinas limpias")
    public void pongoElMouseSobreElBotonCategoriaYEscojoLaOpcionProteinasLimpias(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickOpcionProteinas();
    }
    @When("escojo los productos que deseo llevar y modifico su cantidad")
    public void escojoLosProductosQueDeseoLlevarYModificoSuCantidad(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.clickProductos();
    }
    @When("Doy click en finalizar compra y hago el proceso hasta el pago")
    public void doyClickEnFinalizarCompraYHagoElProcesoHastaElPago(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.finalizarCompra();
    }
    @Then("Redirige a la pagina final en donde nos indica el numero de convenio")
    public void redirigeALaPaginaFinalEnDondeNosIndicaElNumeroDeConvenio(){
        FormaDeLaPagina formaDeLaPagina=new FormaDeLaPagina(super.driver);
        formaDeLaPagina.puntoBaloto();
        try {
            Assertions.assertEquals("1204346", FormaDeLaPagina.convenio);
            LOGGER.info("| Esperado | Obtenido | Resultado |");
            if (FormaDeLaPagina.convenio.equalsIgnoreCase("1204346"))
                LOGGER.info("| 1204346 | "+FormaDeLaPagina.convenio+" | cumple |");
            else
                LOGGER.info("| 1204346 | "+FormaDeLaPagina.convenio+" | no cumple |");
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            Assertions.fail();
        }finally {
            quitDriver();
        }
    }
}
