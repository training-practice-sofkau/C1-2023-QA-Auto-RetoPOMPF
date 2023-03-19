package com.sofkau.stepdefinitions;

import com.sofkau.pages.CompraVueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class CompraVueloStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(CompraVueloStepDefinition.class);

    @Given("el usuario esta en la pagina principal y selecciona la opcion de vuelos usando  {string}")
    public void elUsuarioEstaEnLaPaginaPrincipalYSeleccionaLaOpcionDeVuelosUsando(String SeleccionNavegador) {
        generalSetup(SeleccionNavegador);
        //CompraVueloPage compraVueloPage = new CompraVueloPage(super.driver);
        //compraVueloPage.FillMandatoryFields();
        LOGGER.warn("Por fin pude correr esto");

    }

    @When("seleccione su destino y llena el formulario")
    public void seleccioneSuDestinoYLlenaElFormulario() throws InterruptedException {
        CompraVueloPage compraVueloPage = new CompraVueloPage(super.driver);
        compraVueloPage.FillMandatoryFields();
        compraVueloPage.closeLogin();
        compraVueloPage.filtrarOrigen("Pereira");
        compraVueloPage.filtrarDestino("Bogota");
       // compraVueloPage.seleccionarFechaIda();
        compraVueloPage.clickCualquierFecha();
        compraVueloPage.clickBotonBuscarVuelo();
        compraVueloPage.seleccionarPasajeros();

    }

    @Then("debe observar que el vuelo se ha reservado exitosamente")
    public void debeObservarQueElVueloSeHaReservadoExitosamente() {


    }
}