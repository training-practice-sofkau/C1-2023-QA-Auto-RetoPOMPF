package com.sofkau.stepdefinitions;

import com.sofkau.models.Passenger;
import com.sofkau.pages.LatamPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static com.sofkau.setup.ConstantSetup.HOME_URL;

public class LatamStepDefinition extends WebUi {

    private LatamPage latamPage;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(LatamStepDefinition.class));

    @Given("Given que estoy en la pagina de Latam Airlines")
    public void givenQueEstoyEnLaPaginaDeLatamAirlines() {
        generalSetUp(HOME_URL);
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("he ingresado los detalles de mi viaje")
    public void heIngresadoLosDetallesDeMiViaje() {
        latamPage  = new LatamPage(super.driver);
        latamPage.fillSearchForm();
        latamPage.selectTickets();
    }
    @When("he ingresado los datos de los pasajeros")
    public void heIngresadoLosDatosDeLosPasajeros() {
        List<Passenger> passengers = Passenger.createPassengers(3);
        latamPage.fillPassengers(passengers);
    }
    @Then("se muestra la descripcion del viaje en el modulo de pagar")
    public void seMuestraLaDescripcionDelViajeEnElModuloDePagar() {
        try {
            Thread.sleep(5000);
            quitDriver();
        }catch (Exception e){
            Assertions.fail();
        }

    }
}
