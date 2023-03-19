package com.sofkau.stepdefinitions;

import com.sofkau.models.Usuario;
import com.sofkau.pages.ReservaVueloPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;

public class ReservaVueloStepDefinition extends WebUI {

    private ReservaVueloPage reservaVueloPage;

    private Usuario usuario;

    public static Logger LOGGER = Logger.getLogger(ReservaVueloStepDefinition.class);


    /**
     * escenario 1
     */
    @Given("el usuario esta en la pagina principal de despegar en la opcion vuelos")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarEnLaOpcionVuelos() {

    }

    @When("el usuario selecciona el lugar de origen-destino,  opcion ida y vuelta, fecha inicio y regreso, cantidad de pasajeros, y clase de tiquete, opcion buscar")
    public void elUsuarioSeleccionaElLugarDeOrigenDestinoOpcionIdaYVueltaFechaInicioYRegresoCantidadDePasajerosYClaseDeTiqueteOpcionBuscar() {

    }

    @When("el usuario elije el vuelo, indica el equipaje y realiza el checkout con sus datos  nombre Juan, apellido Perez,  pais de resisencia Colombia, documento {int} fecha de nacimiento dia12 mes03 anio1990 generoMasculino")
    public void elUsuarioElijeElVueloIndicaElEquipajeYRealizaElCheckoutConSusDatosNombreJuanApellidoPerezPaisDeResisenciaColombiaDocumentoFechaDeNacimientoDia12Mes03Anio1990GeneroMasculino(Integer int1) {

    }

    @Then("el usuario debera observar un mensaje reserva exitosa")
    public void elUsuarioDeberaObservarUnMensajeReservaExitosa() {

    }

    /**
     * escenario 2
     *
     * @param SeleccionNavegador
     */


    @Given("el usuario esta en la pagina principal de despegar.com opcion vuelos {string}")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarComOpcionVuelos(String SeleccionNavegador) {
        generalSetup(SeleccionNavegador);
        LOGGER.warn("Inicializando la automatizacion");

    }

    @When("el usuario elije un lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar")
    public void elUsuarioElijeUnLugarDeOrigenDestinoOpcionIdaFechaCantidadDePasajerosYClaseDeTiqueteYOpcionBuscar() throws InterruptedException {
        ReservaVueloPage reservaVueloPage = new ReservaVueloPage(super.driver, usuario);
        reservaVueloPage.clickInicio();
        reservaVueloPage.selectRuta();
        reservaVueloPage.selectVuelo();
        reservaVueloPage.llenarFormulario();
        reservaVueloPage.llenarCorreoNumero();
        reservaVueloPage.emitirFactura();
    }

    @Then("el usuario debera ver un mensaje reserva exitosa")
    public void elUsuarioDeberaVerUnMensajeReservaExitosa() {
        try {

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        } finally {
            //quiteDriver();
        }
    }


    /**
     * escenario 3
     */


    @Given("el usuario se encuentra en la pagina principal  de despegar")
    public void elUsuarioSeEncuentraEnLaPaginaPrincipalDeDespegar() {

    }

    @When("el usuario elije el lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar")
    public void elUsuarioElijeElLugarDeOrigenDestinoOpcionIdaFechaCantidadDePasajerosYClaseDeTiqueteYOpcionBuscar() {

    }

    @Then("el usuario debera observar un mensaje no hay vuelos disponibles")
    public void elUsuarioDeberaObservarUnMensajeNoHayVuelosDisponibles() {

    }


    @Given("el usuario se encuetra en la pagina principal de despegar.com")
    public void elUsuarioSeEncuetraEnLaPaginaPrincipalDeDespegarCom() {

    }

    @When("el usuario selecciona  lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar")
    public void elUsuarioSeleccionaLugarDeOrigenDestinoOpcionIdaFechaCantidadDePasajerosYClaseDeTiqueteYOpcionBuscar() {

    }

    @When("el usuario elije el vuelo, indica el equipaje, elije la opcion con escala, realiza el checkout con sus datos")
    public void elUsuarioElijeElVueloIndicaElEquipajeElijeLaOpcionConEscalaRealizaElCheckoutConSusDatos() {

    }

    @Then("debera observar un mensaje vuelo reservado con escala")
    public void deberaObservarUnMensajeVueloReservadoConEscala() {

    }
}
