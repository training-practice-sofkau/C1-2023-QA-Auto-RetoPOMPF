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

    @Given("Given que estoy en la pagina de Latam Airlines en el navegador {string}")
    public void givenQueEstoyEnLaPaginaDeLatamAirlinesEnElNavegador(String string) {
        String nav = string;
        generalSetUp(HOME_URL, nav);
        LOGGER.info("Inicio de la Automatizacion");
    }

    @When("he ingresado los detalles de mi viaje con {string}")
    public void heIngresadoLosDetallesDeMiViajeCon(String string) {
        latamPage  = new LatamPage(super.driver);
        latamPage.fillSearchForm(string);
        latamPage.selectTickets();
    }
    @When("he ingresado los datos de los pasajeros")
    public void heIngresadoLosDatosDeLosPasajeros() {
        List<Passenger> passengers = Passenger.createPassengers(3);
        latamPage.fillPassengers(passengers);
    }
    @Then("se muestra el modulo para pagar con PSE")
    public void seMuestraElModuloParaPagarConPSE() {
            try {
                String obtainedMessage = latamPage.paymentWithPSE();
                String ExpectedMessage = "Si ya eres parte de LATAM, ingresa tus datos:";
                System.out.println(obtainedMessage);
                Assertions.assertEquals(ExpectedMessage, obtainedMessage);
                Thread.sleep(5000);
                quitDriver();
            }catch (Exception e){
                e.getMessage();
                quitDriver();
            }
    }
}
