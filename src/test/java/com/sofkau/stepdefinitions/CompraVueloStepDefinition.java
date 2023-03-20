package com.sofkau.stepdefinitions;

import com.sofkau.models.InformacionFormularioComprarVuelo;
import com.sofkau.pages.CompraVueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CompraVueloStepDefinition extends WebUI {
    private InformacionFormularioComprarVuelo persona;
    public static Logger LOGGER = Logger.getLogger(CompraVueloStepDefinition.class);

    @Given("el usuario esta en la pagina principal y selecciona la opcion de vuelos usando  {string}")
    public void elUsuarioEstaEnLaPaginaPrincipalYSeleccionaLaOpcionDeVuelosUsando(String SeleccionNavegador) {
        generalSetup(SeleccionNavegador);
        LOGGER.warn("Por fin pude correr esto");

    }

    @When("seleccione su destino y llena el formulario")
    public void seleccioneSuDestinoYLlenaElFormulario() throws InterruptedException {
        CompraVueloPage compraVueloPage = new CompraVueloPage(super.driver,generarInfo());
        compraVueloPage.FillMandatoryFields();
        compraVueloPage.closeLogin();
        compraVueloPage.filtrarOrigen("Bogota");
        compraVueloPage.filtrarDestino("Medellin");
        compraVueloPage.clickCualquierFecha();
        compraVueloPage.clickBotonBuscarVuelo();
        compraVueloPage.seleccionarPasajeros();
        compraVueloPage.llenarFormulario();

    }

    @Then("debe observar que el vuelo se ha reservado exitosamente")
    public void debeObservarQueElVueloSeHaReservadoExitosamente() {
        CompraVueloPage compraVueloPage = new CompraVueloPage(super.driver,generarInfo());
        String textoEnPantalla= compraVueloPage.CompararTexto();
        Assertions.assertEquals("\u00A1Genial! Ahora solo te falta realizar el pago.",textoEnPantalla);

    }


    private InformacionFormularioComprarVuelo generarInfo() {
        persona = new InformacionFormularioComprarVuelo();
        persona.setNombre("Homero");
        persona.setApellido("Simpson");
        persona.setCorreo("Bartsimpson22@gmail.com");
        persona.setNumeroCelular("32292020212");
        persona.setNumeroDocumento("1005773000221");
        persona.setNombreFactura("FacturaNombre");
        persona.setApellidoFactura("FacturApe");
        persona.setNumeroDeIdentificacionFactura("19227222123221");
        persona.setDireccionFactura("Calle falsa 123");
        persona.setOringen("Bogota");
        persona.setDestino("Medellin");
        return persona;
    }
}