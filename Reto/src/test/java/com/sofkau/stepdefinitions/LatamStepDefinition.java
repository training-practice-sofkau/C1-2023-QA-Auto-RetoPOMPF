package com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import com.sofkau.pages.LatamPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import javax.swing.text.html.parser.Parser;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LatamStepDefinition extends WebUi {



    @Given("que estoy en la pagina principal de latam usando el {string}")
    public void queEstoyEnLaPaginaPrincipalDeLatamUsandoEl(String navegador) {
        if(navegador.equals("chrome")){
            generalSetupChrome();
        } else if (navegador.equals("edge")) {
            generalSetupEdge();
        }
    }
    @When("realizo todo el flujo de compra para {int} adultos saliendo desde {string} hasta {string}")
    public void realizoTodoElFlujoDeCompraParaAdultosSaliendoDesdeHasta(Integer cantidad, String salida, String llegada) throws InterruptedException{
        LatamPage latamPage=new LatamPage(super.driver);
        latamPage.navigatePage(cantidad, salida, llegada);
    }
    @Then("confirmo la informacion antes de realizar la compra")
    public void confirmoLaInformacionAntesDeRealizarLaCompra() {
        try{
            Assertions.assertEquals(LatamPage.confrimarFlujo1,"Ingresa los datos de tu tarjeta");
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
        }finally {
            quiteDriver();
        }
    }
}
