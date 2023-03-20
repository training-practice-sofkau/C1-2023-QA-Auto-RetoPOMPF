package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BookingPage;
import setup.WebUI;


import java.util.logging.Logger;

import static setup.ConstantSetup.WEB_PAGE_URL;

public class BookingStepDefinitions extends WebUI {
    private static Logger LOGGER = Logger.getLogger(String.valueOf(BookingStepDefinitions.class));

    @Given("estoy en la pagina web deseada usando un navegador {string}")
    public void estoy_en_la_pagina_web_deseada_usando_un_navegador(String string) {
        String navegador = string;
        generalSetUp(WEB_PAGE_URL, navegador);
    }

    @When("selecciono los destinos y la cantidad de pasajeros")
    public void selecciono_los_destinos_y_la_cantidad_de_pasajeros() throws InterruptedException {
        BookingPage bookingPage = new BookingPage(super.driver);
        bookingPage.SelectFlightsAndDates();
        bookingPage.FillPassengersForm();
    }

    @When("se agrega una cantidad de equipaje {integer}")
    public void se_agrega_una_cantidad_de_equipaje(Integer equipaje) {


    }

    @Then("ingreso mis datos e informacion de pago")
    public void ingreso_mis_datos_e_informacion_de_pago() {
        try {
            String obtainedMessage = BookingPage.payment();
            String ExpectedMessage = "Ingresa los datos de tu tarjeta";
            System.out.println(obtainedMessage);
            Assertions.assertEquals(ExpectedMessage, obtainedMessage);
            quitDriver();
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            quitDriver();

        }
    }
}