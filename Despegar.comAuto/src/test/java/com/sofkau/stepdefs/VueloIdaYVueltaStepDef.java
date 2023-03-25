package com.sofkau.stepdefs;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VueloIdaYVueltaStepDef extends WebUI {

    @Given("I went to Despegar flights page with a browser {string}")
    public void iWentToDespegarHomePageFlightsTabWithABrowserBrowser(String browser) {
    }

    @And("I selected the passengers")
    public void iSelectedThePassengers() {
    }

    @And("I selected the destinations")
    public void iSelectedTheDestinations() {
    }

    @Then("I will be redirected to the flight selection page")
    public void iWillBeRedirectedToTheFlightSelectionPage() {
    }

    @When("I select the {string} and the {string}")
    public void iSelectTheAndThe(String dateD, String dateR) {

    }

    @And("I select the flight Economy")
    public void iSelectTheFlightEconomy() {

    }

    @And("I select the flight First class")
    public void iSelectTheFlightFirstClass() {

    }

    @And("I select the flight Premium economy")
    public void iSelectTheFlightPremiumEconomy() {

    }

    @When("I activate the I have not decided the dates yet toggle switch")
    public void iActivateTheIHavenTDecidedTheDatesYetToggleSwitch() {
    }
}