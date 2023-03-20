package com.sofkau.stepdefs;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConst.TRANSFER_URL;

public class TrasladosStepDef extends WebUI {
    private final Logger log = LoggerFactory.getLogger(TrasladosStepDef.class);

    @Given("I went to Despegar transfer page with a browser {string}")
    public void iWentToDespegarTransferPageWithABrowser(String browser) {
        try {
            log.info("Init scenario");
            generalSetup(browser, TRANSFER_URL);
        } catch (Exception e) {
            log.error("Wrong Setup provided");
            quitDriver();
        }
    }

    @Given("I selected the required fields for my family")
    public void iSelectedTheRequiredFieldsForMyFamily() {
    }

    @When("I buy the first transfer option")
    public void iBuyTheFirstTransferOption() {
    }

    @Then("I will be redirected to payment page")
    public void iWillBeRedirectedToPaymentPage() {
    }

    @Given("I selected the required fields only for me")
    public void iSelectedTheRequiredFieldsOnlyForMe() {
    }

    @When("I focus on the price of the first transfer option")
    public void iFocusOnThePriceOfTheFirstTransferOption() {
    }

    @Then("I will see a lower price than with my family")
    public void iWillSeeALowerPriceThanWithMyFamily() {
    }
}