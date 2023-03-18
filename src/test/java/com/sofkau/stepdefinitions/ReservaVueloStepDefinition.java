package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReservaVueloStepDefinition {


    /**
     * ESCENARIO 1
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
     * ESCENARIO 2
     */
    @Given("el usuario esta en la pagina principal de despegar.com opcion vuelos")
    public void elUsuarioEstaEnLaPaginaPrincipalDeDespegarComOpcionVuelos() {

    }

    @When("el usuario elije un lugar de origen-destino,  opcion ida, fecha, cantidad de pasajeros, y clase de tiquete, y opcion buscar")
    public void elUsuarioElijeUnLugarDeOrigenDestinoOpcionIdaFechaCantidadDePasajerosYClaseDeTiqueteYOpcionBuscar() {

    }

    @Then("el usuario debera ver un mensaje reserva exitosa")
    public void elUsuarioDeberaVerUnMensajeReservaExitosa() {

    }




    /**
     * ESCENARIO 3
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
