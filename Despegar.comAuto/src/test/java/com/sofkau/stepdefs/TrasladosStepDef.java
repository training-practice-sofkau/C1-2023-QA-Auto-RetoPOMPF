package com.sofkau.stepdefs;

import com.sofkau.pages.*;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConst.*;
import static com.sofkau.setup.SetUpConst.FINAL_TITLE;

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
        try {
            log.info("Setup scenario");
            TrasladosPage trasladosPage = new TrasladosPage(super.driver);
            trasladosPage.setupTransferPage();
        } catch (Exception e) {
            log.error("Wrong steps provided");
            quitDriver();
        }
    }

    @When("I buy the first transfer option")
    public void iBuyTheFirstTransferOption() {
        try {
            log.info("Running selection");
            ComprarTrasladosPage comprarTrasladosPage = new ComprarTrasladosPage(super.driver);
            comprarTrasladosPage.buyFirst();
        } catch (Exception e) {
            log.error("Wrong steps provided");
            quitDriver();
        }
    }

    @Then("I will be redirected to payment page")
    public void iWillBeRedirectedToPaymentPage() {
        try {
            PaymentPage paymentPage = new PaymentPage(super.driver);
            String eTitle = paymentPage.seeTitle();
            Assertions.assertEquals(TITLE, eTitle);
            log.info("Test passed");
            log.info(String.format("Expected: %s", TITLE));
            log.info(String.format("Actual: %s", eTitle));
        } catch (Exception e) {
            log.error("Test failed");
            quitDriver();
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }

    @Given("I selected the required fields only for me")
    public void iSelectedTheRequiredFieldsOnlyForMe() {
        try {
            log.info("Setup scenario");
            TrasladosPage trasladosPage = new TrasladosPage(super.driver);
            trasladosPage.setupTransferPage4Me();
        } catch (Exception e) {
            quitDriver();
        }
    }

    @When("I focus on the price of the first transfer option")
    public void iFocusOnThePriceOfTheFirstTransferOption() {
        try {
            log.info("Running selection");
            ComprarTrasladosPage comprarTrasladosPage = new ComprarTrasladosPage(super.driver);
            String price = comprarTrasladosPage.getPrice();
            log.info(String.format("Precio: $ %s", price));
        } catch (Exception e) {
            quitDriver();
        }
    }

    @Then("I will see a lower price than with my family")
    public void iWillSeeALowerPriceThanWithMyFamily() {
        try {
            ComprarTrasladosPage comprarTrasladosPage = new ComprarTrasladosPage(super.driver);
            String ePrice = comprarTrasladosPage.getPrice();
            Assertions.assertEquals(PRICE, ePrice);
            log.info("Test passed");
            log.info(String.format("Expected: $ %s", PRICE));
            log.info(String.format("Actual: $ %s", ePrice));
        } catch (Exception e) {
            quitDriver();
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}