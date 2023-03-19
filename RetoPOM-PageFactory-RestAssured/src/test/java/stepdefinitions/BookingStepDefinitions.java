package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;
import setup.WebUI;

public class BookingStepDefinitions extends WebUI {

    @Given("estoy en la pagina web deseada")
    public void estoy_en_la_pagina_web_deseada() {
        generalSetUp();
    }
    @When("selecciono los destinos y la cantidad de pasajeros")
    public void selecciono_los_destinos_y_la_cantidad_de_pasajeros() {
        BookingPage bookingPage = new BookingPage(super.driver);
        bookingPage.FillMandatoryFields();
        //quitDriver();
    }
    @When("selecciono un vuelo disponible")
    public void selecciono_un_vuelo_disponible() {

    }
    @Then("ingreso mis datos e informacion de pago")
    public void ingreso_mis_datos_e_informacion_de_pago() {

    }
}
