package com.sofkau.stepdefinitions;

import com.sofkau.models.InformacionFormularioComprarVuelo;
import com.sofkau.pages.CompraVueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

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


    }


    private InformacionFormularioComprarVuelo generarInfo() {
        persona = new InformacionFormularioComprarVuelo();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setCorreo("correofalsoSanti@gmail.com");
        persona.setNumeroCelular("123456789");
        persona.setNumeroDocumento("123456789111");
        persona.setNumeroDocumento("1234567891111");
        persona.setNombreFactura("Factura");
        persona.setApellidoFactura("FacturApe");
        persona.setNumeroDeIdentificacionFactura("123456789111");
        persona.setDireccionFactura("Calle falsa 123");
        persona.setOringen("Bogota");
        persona.setDestino("Medellin");
        return persona;
    }
}