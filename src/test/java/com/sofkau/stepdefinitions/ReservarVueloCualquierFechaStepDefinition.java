package com.sofkau.stepdefinitions;

import com.sofkau.models.Usuario;
import com.sofkau.pages.ReservaConEscala;
import com.sofkau.pages.ReservaVueloPage;
import com.sofkau.setup.ConstantSetup;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ReservarVueloCualquierFechaStepDefinition extends WebUI {
    private ReservaVueloPage reservaVueloPage;

    private ConstantSetup consttanSetup;
    private Usuario usuario;


    private ReservaConEscala reservaConEscala;
    public static Logger LOGGER = Logger.getLogger(ReservaVueloStepDefinition.class);
    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";


    /**
     * Primero Escenario
     */


    @Given("el usuario esta en la pagina principal  de despegar.com")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarCom() {

    }

    @When("el usuario selecciona el lugar de origen-destino,  opcion ida, opcion cualquier fecha mas barata, opcion buscar")
    public void elUsuarioSeleccionaElLugarDeOrigenDestinoOpcionIdaOpcionCualquierFechaMasBarataOpcionBuscar() {

    }

    @When("el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos")
    public void elUsuarioElijeElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatos() {

    }

    @Then("el usuario debe observar una reserva del vuelo")
    public void elUsuarioDebeObservarUnaReservaDelVuelo() {

    }

    /**
     * Segundo Escenario
     */


    @Given("el usuario esta en la pagina principal de despegar")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegar() {
        generalSetup1();
        LOGGER.warn("Inicializando la automatizacion");
    }

    @When("el cliente elije el lugar de origen-destino, ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, clase de tiquete, opcion buscar")
    public void elClienteElijeElLugarDeOrigenDestinoIdaYVueltaFechaInicioYRegresoCantidadDePasajerosClaseDeTiqueteOpcionBuscar() {

        try {
            ReservaConEscala reservaConEscala = new ReservaConEscala(super.driver, usuario);
            reservaConEscala.clickInicio();


        } catch (Exception exception) {
            quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }

    @When("el usuario selecciona la aeroplinea, elije el vuelo, indica el equipaje y realiza el checkout con sus datos")
    public void elUsuarioSeleccionaLaAeroplineaElijeElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatos() {
        try {
            ReservaConEscala reservaConEscala = new ReservaConEscala(super.driver, usuario);
            reservaConEscala.selectRuta();
            reservaConEscala.selectVuelo();
            reservaConEscala.llenarFormulario();
            reservaConEscala.llenarCorreoNumero();
            reservaConEscala.emitirFactura();

        } catch (Exception exception) {
            quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }

    @Then("el usuario debe observar un mensaje reserva exitosa")
    public void elUsuarioDebeObservarUnMensajeReservaExitosa() {
        try {
            reservaConEscala = new ReservaConEscala(super.driver, usuario);
            Assertions.assertEquals(MensajeFinal, reservaVueloPage.getTextoFinal());
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
        return "\n" + reservaVueloPage.getTextoFinal();

    }

}
