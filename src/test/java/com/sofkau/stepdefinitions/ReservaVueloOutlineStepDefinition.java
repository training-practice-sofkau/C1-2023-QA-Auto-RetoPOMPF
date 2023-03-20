package com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import com.sofkau.models.Usuario;
import com.sofkau.pages.ReservaConEscala;
import com.sofkau.pages.ReservaVueloOutlinePage;
import com.sofkau.pages.ReservaVueloPage;
import com.sofkau.setup.ConstantSetup;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReservaVueloOutlineStepDefinition extends WebUI {

    private ReservaVueloOutlinePage reservaVueloOutlinePage;

    private ConstantSetup consttanSetup;
    private Usuario usuario;
    public static Logger LOGGER = Logger.getLogger(ReservaVueloStepDefinition.class);
    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";


    @Given("el usuario esta en la pagina principal de despegar en la opcion vuelos con el vavegador  {string}")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarEnLaOpcionVuelosConElVavegador(String SeleccionNavegador) {
        generalSetup(SeleccionNavegador);
        LOGGER.warn("Inicializando la automatizacion");
    }

    @When("el usuario selecciona el lugar de origen-destino, opcion ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, y clase de tiquete, opcion buscar")
    public void elUsuarioSeleccionaElLugarDeOrigenDestinoOpcionIdaYVueltaFechaInicioYRegresoCantidadDePasajerosYClaseDeTiqueteOpcionBuscar() {
        try {
            ReservaVueloOutlinePage reservaVueloOutlinePage = new ReservaVueloOutlinePage(super.driver, usuario);
            reservaVueloOutlinePage.clickInicio();

        } catch (Exception exception) {
            quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }

    @When("el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos nombre {string}, apellido {string}, documento {string}")
    public void elUsuarioElijeElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatosNombreApellidoDocumento(String nombre, String apellido, String documento) {

        try {
            ReservaVueloOutlinePage reservaVueloOutlinePage = new ReservaVueloOutlinePage(super.driver, usuario);
            reservaVueloOutlinePage.clickInicio();
            reservaVueloOutlinePage.selectRuta();
            reservaVueloOutlinePage.selectVuelo();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setDocumento(documento);
            reservaVueloOutlinePage.llenarCorreoNumero();
            reservaVueloOutlinePage.emitirFactura();

        } catch (Exception exception) {
            quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }


    @Then("el usuario debera observar un mensaje reserva exitosa de sus tiquetes")
    public void elUsuarioDeberaObservarUnMensajeReservaExitosaDeSusTiquetes() {
        try {
            reservaVueloOutlinePage = new ReservaVueloOutlinePage(super.driver, usuario);
            Assertions.assertEquals(MensajeFinal, reservaVueloOutlinePage.getTextoFinal());
            System.out.println(resultado());
            System.out.println(MensajeFinal);
            String.format(ASSERTION_EXCEPTION_MESSAGE, resultado(), MensajeFinal);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        } finally {
            quiteDriver();
        }
    }


    private String resultado() {
        return "\n" + reservaVueloOutlinePage.getTextoFinal();

    }


}
