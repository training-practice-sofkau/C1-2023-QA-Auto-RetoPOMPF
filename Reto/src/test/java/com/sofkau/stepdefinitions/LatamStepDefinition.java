package com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import com.sofkau.pages.LatamPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.text.html.parser.Parser;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LatamStepDefinition extends WebUi {



    @Given("que estoy en la pagina principal de latam")
    public void queEstoyEnLaPaginaPrincipalDeLatam() {
        generalSetup();
    }
    @When("realizo todo el flujo de compra")
    public void realizoTodoElFlujoDeCompra() throws InterruptedException{
        try {
            LatamPage latamPage=new LatamPage(super.driver);
            latamPage.navigatePage();

        }catch (Exception e){
            e.getMessage();
            //quiteDriver();
        }
    }
    @Then("confirmo la informacion antes de realizar la compra")
    public void confirmoLaInformacionAntesDeRealizarLaCompra() {

    }
}
