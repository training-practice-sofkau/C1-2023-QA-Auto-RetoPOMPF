package com.sofkau.stepdefs;

import com.sofkau.pages.AsistenciasPage;
import com.sofkau.pages.ComprarAsistenciasPage;
import com.sofkau.pages.PaymentPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConst.ASSIST_URL;
import static com.sofkau.setup.SetUpConst.TITLE;

public class AsistenciasStepDef extends WebUI {
    private final Logger log = LoggerFactory.getLogger(AsistenciasStepDef.class);

    @Given("I went to Despegar assistance page with a browser {string}")
    public void iWentToDespegarAssistancePageWithABrowser(String browser) {
        try {
            generalSetup(browser, ASSIST_URL);
        } catch (Exception e) {
            // log.error("Wrong Setup provided");
            quitDriver();
        }
    }

    @Given("I selected the required fields for my family and me")
    public void iSelectedTheRequiredFieldsForMyFamilyAndMe() {
        try {
            AsistenciasPage asistenciasPage = new AsistenciasPage(super.driver);
            asistenciasPage.setupAssistPage();
        } catch (Exception e) {
            // log.error("Wrong steps provided");
            quitDriver();
        }

    }

    @When("I buy the recommended assistance option")
    public void iBuyTheRecommendedAssistanceOption() {
        try {
            ComprarAsistenciasPage comprarAsistenciasPage = new ComprarAsistenciasPage(super.driver);
            comprarAsistenciasPage.buyRecommended();
        } catch (Exception e) {
            // log.error("Wrong steps provided");
            quitDriver();
        }
    }

    @Then("I will be redirected to the payment page")
    public void iWillBeRedirectedToThePaymentPage() {
        try {
            PaymentPage paymentPage = new PaymentPage(super.driver);
            Assertions.assertEquals(TITLE, paymentPage.seeTitle());
        } catch (Exception e) {
            // log.error("Test failed");
            quitDriver();
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }

    @Given("I bought the recommended assistance option")
    public void iBoughtTheRecommendedAssistanceOption() {
        try {
            AsistenciasPage asistenciasPage = new AsistenciasPage(super.driver);
            asistenciasPage.setupAssistPage();
            ComprarAsistenciasPage comprarAsistenciasPage = new ComprarAsistenciasPage(super.driver);
            comprarAsistenciasPage.buyRecommended();
        } catch (Exception e) {
            quitDriver();
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }

    @When("I fill all the purchase fields")
    public void iFillAllThePurchaseFields() {
        try {

        } catch (Exception e) {
            quitDriver();
            Assertions.fail();
        }
    }

    @Then("I will be redirected to the booking confirmation page and awaiting payment")
    public void iWillBeRedirectedToTheBookingConfirmationPageAndAwaitingPayment() {
        try {

        } catch (Exception e) {
            quitDriver();
            Assertions.fail();
        } finally {
            quitDriver();
        }
    }
}