package com.sofkau.stepdefinitions;

import com.sofkau.models.Usuario;
import com.sofkau.pages.ReservaTiqueteMultidestinoPage;
import com.sofkau.setup.ConstantSetup;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ReservaTiqueteMultidestino extends WebUI {
    private ReservaTiqueteMultidestinoPage reservaTiqueteMultidestinoPage;

    private ConstantSetup consttanSetup;
    private Usuario usuario;


    public static Logger LOGGER = Logger.getLogger(ReservaVueloStepDefinition.class);
    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";

    @Given("el usuario esta en la pagina principal  de despegar")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegar() {

    }

    @When("el usuario selecciona multidestino, el tramo uno de origen-destino, fecha salida, cantidad de pasajeros, tramo dos opcion destino, fecha salida,   opcion buscar, clase de tiquete")
    public void elUsuarioSeleccionaMultidestinoElTramoUnoDeOrigenDestinoFechaSalidaCantidadDePasajerosTramoDosOpcionDestinoFechaSalidaOpcionBuscarClaseDeTiquete() {

    }

    @When("el usuario selecciona el vuelo, indica el equipaje y realiza el checkout con sus datos")
    public void elUsuarioSeleccionaElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatos() {

    }

    @Then("el usuario debera observar una reserva del vuelo exitosa")
    public void elUsuarioDeberaObservarUnaReservaDelVueloExitosa() {

    }


    @Given("el usuario esta en la pagina principal  de despegar opcion vuelo {string}")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarOpcionVuelo(String SeleccionNavegador) {
        generalSetup(SeleccionNavegador);
        LOGGER.warn("Inicializando la automatizacion");

    }

    @When("el usuario elije multidestino, el tramo uno de origen-destino, fecha salida, cantidad de pasajeros , tramo dos opcion destino, fecha salida,   opcion buscar, clase de tiquete")
    public void elUsuarioElijeMultidestinoElTramoUnoDeOrigenDestinoFechaSalidaCantidadDePasajerosTramoDosOpcionDestinoFechaSalidaOpcionBuscarClaseDeTiquete() {

        try {
            ReservaTiqueteMultidestinoPage reservaTiqueteMultidestinoPage = new ReservaTiqueteMultidestinoPage(super.driver, usuario);
            reservaTiqueteMultidestinoPage.clickInicio();
        } catch (Exception exception) {
            //quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }



    @When("el usuario toma el vuelo, indica el equipaje y realiza el checkout con sus datos")
    public void elUsuarioTomaElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatos() {
        try {
            ReservaTiqueteMultidestinoPage reservaTiqueteMultidestinoPage = new ReservaTiqueteMultidestinoPage(super.driver, usuario);
            reservaTiqueteMultidestinoPage.selectRuta();
            reservaTiqueteMultidestinoPage.selectVuelo();
            reservaTiqueteMultidestinoPage.llenarFormulario();
            reservaTiqueteMultidestinoPage.llenarCorreoNumero();
            reservaTiqueteMultidestinoPage.emitirFactura();

        } catch (Exception exception) {
           // quiteDriver();
            LOGGER.warn(exception.getMessage());
        }
    }

    @Then("el usuario debera observar una reserva del vuelo")
    public void elUsuarioDeberaObservarUnaReservaDelVuelo() {
        try {
            reservaTiqueteMultidestinoPage = new ReservaTiqueteMultidestinoPage(super.driver, usuario);
            Assertions.assertEquals(MensajeFinal, reservaTiqueteMultidestinoPage.getTextoFinal());
            System.out.println(resultado());
            System.out.println(MensajeFinal);
            String.format(ASSERTION_EXCEPTION_MESSAGE, resultado(), MensajeFinal);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        } finally {
           // quiteDriver();
        }
    }


    private String resultado() {
        return "\n" + reservaTiqueteMultidestinoPage.getTextoFinal();

    }

}
